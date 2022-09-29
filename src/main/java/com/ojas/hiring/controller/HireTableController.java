package com.ojas.hiring.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ojas.hiring.dto.FormDataRoot;
import com.ojas.hiring.entity.HireTable;
import com.ojas.hiring.entity.SalaryNegotiationDetails;
import com.ojas.hiring.repo.HireTableRepo;
import com.ojas.hiring.service.Impl.HireTableServiceImpl;

/*@Author RavindranathGV*/

@RestController
@RequestMapping("/api")
public class HireTableController {
	private static final Logger logger = LogManager.getLogger(SalNegDetailsGetController.class);
	@Autowired
	private HireTableServiceImpl hireTableServiceImpl;
	@Autowired
	private HireTableRepo hireTableRepo;

	@GetMapping("/getAllHiresInfo")
	public List<HireTable> getAllHiresInfo() {
		return hireTableServiceImpl.getAllInterviewDetails();
	}

	@GetMapping(value = "/getHiresInfoById/{hireId}")
	public Object getHiresInfoById(@PathVariable("hireId") String hireId) {
		ResponseEntity<Object> getHireDetails = hireTableServiceImpl.findByInterviewByHireId(hireId);
		return new ResponseEntity<Object>(getHireDetails, HttpStatus.OK).getBody();
	}
	
	@GetMapping(value = "/getHiresInfoByToken/{id}")
	public Object getHiresInfoByToken(@PathVariable("id") String id) {
		ResponseEntity<Object> getHireDetails = hireTableServiceImpl.findByInterviewByToken(id);
		return new ResponseEntity<Object>(getHireDetails, HttpStatus.OK).getBody();
	}

	@PostMapping(path = "/publishHireeDetails")
	public @ResponseBody String publishHireeDetails(@RequestBody HireTable hireTable) {
		long millis=System.currentTimeMillis();  
	    java.sql.Date date = new java.sql.Date(millis);
	    hireTable.setPublishedDate(date);
        System.out.println(hireTable);

	    HireTable save = hireTableRepo.saveAndFlush(hireTable);
		Gson gson = new GsonBuilder().create();
		String jsonString = gson.toJson(hireTable);
		logger.info("jsonString is ---" + jsonString);
		return jsonString;
	}
}
