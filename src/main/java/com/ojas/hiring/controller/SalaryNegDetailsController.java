package com.ojas.hiring.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ojas.hiring.dto.FormDataRoot;
import com.ojas.hiring.entity.SalaryNegotiationDetails;
import com.ojas.hiring.repo.SalaryNegotiationDetailsRepo;
import com.ojas.hiring.service.Impl.SalaryNegDetailsServiceImpl;

/*@Author Akshaya Kumar Mahanty*/

@Controller
@RequestMapping("/api")
public class SalaryNegDetailsController {

	private static final Logger logger = LogManager.getLogger(SalaryNegDetailsController.class);
	@Autowired
	private SalaryNegDetailsServiceImpl serviceImpl;
	@Autowired
	private SalaryNegotiationDetailsRepo salaryNegotiationDetailsRepo;

	@RequestMapping("/addsalnegdetails")
	public String form(ModelMap model) {
		SalaryNegotiationDetails salNegDetails = new SalaryNegotiationDetails();
		model.addAttribute("salNegDetails", salNegDetails);
		return "salNegDetails";
	}

	@PostMapping(path = "/salNegDetails", consumes = "application/json", produces = "application/json")
	public @ResponseBody String addSalNegDetails(@RequestBody String ajaxRequest) {
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		logger.info("ajax req is  ---" + ajaxRequest);
		FormDataRoot jobj = new Gson().fromJson(ajaxRequest, FormDataRoot.class);
		logger.info("jobj req is  ---" + jobj);
		String hireId = (jobj.getFormDataDTO().get(0).getValue());
		String budget = (jobj.getFormDataDTO().get(1).getValue());
		String negotiated = (jobj.getFormDataDTO().get(2).getValue());
		String offeredCTC = (jobj.getFormDataDTO().get(3).getValue());
		String token = (jobj.getFormDataDTO().get(4).getValue());
		
		logger.info("hireId is ---" + hireId);
		SalaryNegotiationDetails salNegDetails = new SalaryNegotiationDetails();
		salNegDetails.setHireId(Integer.parseInt(hireId));
		salNegDetails.setBudget(Double.parseDouble(budget));
		salNegDetails.setNegotiated(Double.parseDouble(negotiated));
		salNegDetails.setOfferedCTC(Double.parseDouble(offeredCTC));
		salNegDetails.setCreatedDate(date);
		salNegDetails.setToken(token);
		SalaryNegotiationDetails save = salaryNegotiationDetailsRepo.saveAndFlush(salNegDetails);
		Gson gson = new GsonBuilder().create();
		String jsonString = gson.toJson(salNegDetails);
		logger.info("jsonString is ---" + jsonString);
		return jsonString;
	}
	
	@PostMapping(path = "/pubSalNegDetails")
	public  @ResponseBody String pubSalNegDetails(@RequestBody SalaryNegotiationDetails salNegDetails) {
		long millis=System.currentTimeMillis();  
	    java.sql.Date date = new java.sql.Date(millis);   
	    salNegDetails.setCreatedDate(date);
		SalaryNegotiationDetails save = salaryNegotiationDetailsRepo.saveAndFlush(salNegDetails);
		Gson gson = new GsonBuilder().create();
		String jsonString = gson.toJson(salNegDetails);
		logger.info("jsonString is ---" + jsonString);
		return jsonString;
	}
}
