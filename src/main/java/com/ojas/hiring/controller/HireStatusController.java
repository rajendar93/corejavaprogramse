package com.ojas.hiring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.hiring.entity.HireStatus;
import com.ojas.hiring.service.HireStatusService;

@RestController
@RequestMapping("/api/hirestatus")

/* @Author Shobha.Bakkathatla */

public class HireStatusController {

	@Autowired
	 HireStatusService hireservice;

	@PostMapping("/add")
	public HireStatus saveHireObjective(@RequestBody HireStatus hireStatus) {
		return hireservice.saveHireStatus(hireStatus);
	}

	@PutMapping("/update")
	public HireStatus updateHireStatus(@RequestBody HireStatus hireStatus) {
		return hireservice.saveHireStatus(hireStatus);
	}

	@GetMapping("/hirestatusdetails")
	public List<HireStatus> getAllHireStatus() {
		return hireservice.getAllHireStatus();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteHireStatus(@PathVariable int id) {
		hireservice.deleteHireStatus(id);
	}
	
	@GetMapping(value = "/hiredetails/{id}")
	public Object getById(@PathVariable("id") Integer id) {
		ResponseEntity<Object> gethiredetails = hireservice.HireStatusfindById(id);
		return new ResponseEntity<Object>(gethiredetails, HttpStatus.OK).getBody();
	}
}
