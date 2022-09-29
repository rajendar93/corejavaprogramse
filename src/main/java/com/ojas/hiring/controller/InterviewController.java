package com.ojas.hiring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ojas.hiring.dto.FormDataRoot;
import com.ojas.hiring.entity.Interviews;
import com.ojas.hiring.service.InterviewService;

/*@Author Akshaya Kumar Mahanty*/

@Controller
@RequestMapping("/api")
public class InterviewController {

	private static final Logger logger = LogManager.getLogger(InterviewController.class);
	
	@Autowired
	private InterviewService interviewService;
	
	@RequestMapping("/addinterview")
	public String addInterviewDetails(Model model) {
		return "interview";
	}
	
	@PostMapping(path = "/interviewDetails", consumes = "application/json", produces = "application/json")
	public @ResponseBody String addSalNegDetails(@RequestBody String ajaxRequest) {
		logger.info("--------Entry ----------");
		long millis=System.currentTimeMillis();  
	    java.sql.Date date = new java.sql.Date(millis);    
		logger.info("ajax req is  ---" + ajaxRequest);
		FormDataRoot jobj = new Gson().fromJson(ajaxRequest, FormDataRoot.class);
		logger.info("jobj req is  ---" + jobj);
		String hireId = (jobj.getFormDataDTO().get(1).getValue());
		String hireName = (jobj.getFormDataDTO().get(0).getValue());
		String comment = (jobj.getFormDataDTO().get(2).getValue());
		String author = (jobj.getFormDataDTO().get(3).getValue());
		String authorRole = (jobj.getFormDataDTO().get(4).getValue());
		String rating = (jobj.getFormDataDTO().get(6).getValue());
		logger.info("hireId is ---" + hireId);
		Interviews interview = new Interviews();
		interview.setHireId(hireId);  
		interview.setHireName(hireName);
		interview.setComment(comment);
		interview.setAuthor(author);
		interview.setAuthorRole(authorRole);
		interview.setRating(Integer.parseInt(rating));
		interview.setCommentedOn(date);
		Interviews save = interviewService.addInterviewDetails(interview);
		Gson gson = new GsonBuilder().create();
		String jsonString = gson.toJson(interview);
		logger.info("jsonString is ---" + jsonString);
		return jsonString;
	}
	
}
