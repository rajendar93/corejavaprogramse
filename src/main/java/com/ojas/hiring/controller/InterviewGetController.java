package com.ojas.hiring.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.hiring.entity.Interviews;
import com.ojas.hiring.service.InterviewService;
import com.ojas.hiring.service.Impl.InterviewServiceImpl;

/*@Author Akshaya Kumar Mahanty*/

@RestController
@RequestMapping("/api")
public class InterviewGetController {
	private static final Logger logger = LogManager.getLogger(InterviewGetController.class);
	@Autowired
	private InterviewServiceImpl interviewServiceImpl;
	@Autowired
	private InterviewService interviewService;

	@GetMapping("/interviewdetails")
	public List<Interviews> getAll() {
		return interviewService.getAllInterviewDetails();
	}

	@GetMapping(value = "/interviewdetails/{id}")
	public Object getById(@PathVariable("id") int id) {
		ResponseEntity<Object> getHireDetails = interviewService.findByInterviewId(id);
		return new ResponseEntity<Object>(getHireDetails, HttpStatus.OK).getBody();
	}

	@GetMapping("/searchbyhireid/{hireId}")
	public Object searchByHireId(@PathVariable("hireId") String hireId) {
		ResponseEntity<Object> getHireDetails = interviewService.findBySearchHireId(hireId);
		return new ResponseEntity<Object>(getHireDetails, HttpStatus.OK).getBody();
	}

	@PutMapping("/interviewupdate/{id}")
	public ResponseEntity<Object> update(@RequestBody Interviews interview, @PathVariable int id) {
		ResponseEntity<Object> update = interviewService.updateInterview(interview, id);
		return (ResponseEntity<Object>) new ResponseEntity<Object>(update, HttpStatus.ACCEPTED).getBody();
	}
	
	@DeleteMapping("/interviewdelete/{id}")
	public void deleteById(@PathVariable int id) {
		interviewService.deleteInterviewId(id);
	}

}
