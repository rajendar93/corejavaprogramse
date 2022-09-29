package com.ojas.hiring.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.hiring.entity.Interviews;
import com.ojas.hiring.entity.SalaryNegotiationDetails;
import com.ojas.hiring.repo.SalaryNegotiationDetailsRepo;
import com.ojas.hiring.service.SalaryNegDetailsService;
import com.ojas.hiring.service.Impl.SalaryNegDetailsServiceImpl;

/*@Author Akshaya Kumar Mahanty*/

@RestController
@RequestMapping("/api")
public class SalNegDetailsGetController {

	private static final Logger logger = LogManager.getLogger(SalNegDetailsGetController.class);
	@Autowired
	private SalaryNegDetailsServiceImpl serviceImpl;
	@Autowired
	private SalaryNegDetailsService salaryNegDetailsService;
	@Autowired
	private SalaryNegotiationDetailsRepo salaryNegotiationDetailsRepo;
	
	@GetMapping("/salnegdetails")
	public List<SalaryNegotiationDetails> getAllSalNegDetails() {
		return salaryNegDetailsService.getAllSalaryNegDetails();
	}
	
	@GetMapping(value = "/salnegdetails/{hireId}")
	public  Object getById(@PathVariable ("hireId") int hireId ){
		 ResponseEntity<Object> getHireDetails = salaryNegDetailsService.findByHireId(hireId);
		return  new ResponseEntity<Object>(getHireDetails,HttpStatus.OK).getBody();
	}
	
	@GetMapping(value = "/salNegDetailsIntId/{id}")
	public  Object getByToken(@PathVariable ("id") int id ){
		 ResponseEntity<Object> getHireDetails = salaryNegDetailsService.findByToken(id);
		return  new ResponseEntity<Object>(getHireDetails,HttpStatus.OK).getBody();
	}
	@PutMapping("/salnegdetails/updatebyhireid/{hireId}")
	public ResponseEntity<Object> update(@RequestBody SalaryNegotiationDetails salNegDetails, @PathVariable int hireId) {
		Object update = salaryNegDetailsService.updateSalNegDetails(salNegDetails, hireId);
		return new ResponseEntity<Object>(update, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/salnegdetails/updatebytoken/{tokenId}")
	public ResponseEntity<Object> updates(@RequestBody SalaryNegotiationDetails salNegDetails, @PathVariable int tokenId) {
		ResponseEntity<Object> update = salaryNegDetailsService.updatebytokenSalNegDetails(salNegDetails, tokenId);
		return (ResponseEntity<Object>) new ResponseEntity<Object>(update, HttpStatus.ACCEPTED).getBody();
	}
	
	@DeleteMapping("/salnegdetails/deletebyhireid/{hireId}")
	public void deleteByhireId(@PathVariable("hireId") int hireId) {
		salaryNegDetailsService.deleteSalNegDetailsByHireId(hireId);
	}
	
	@DeleteMapping("/salnegdetails/deletebytokenid/{tokenId}")
	public void deleteByToken(@PathVariable("tokenId") int tokenId) {
		salaryNegDetailsService.deleteSalNegDetailsByTokenId(tokenId);
	}
}
