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

import com.ojas.hiring.entity.HireObjective;
import com.ojas.hiring.service.HireObjectiveService;

@RestController
@RequestMapping("/api/hireObjective")

/* @Author Shobha.Bakkathatla */
public class HireObjectiveController {

	@Autowired
	HireObjectiveService service;

	@PostMapping("/add")
	public HireObjective saveHireObjective(@RequestBody HireObjective hireObjective) {
		return service.saveHireObjective(hireObjective);
	}

	@PutMapping("/update")
	public HireObjective updateHireObjective(@RequestBody HireObjective hireObjective) {
		return service.updaterHireObjective(hireObjective);
	}

	@GetMapping("/hiredetails")
	public List<HireObjective> getAllHireObjective() {
		return service.getAllHireObjective();
	}

	@GetMapping(value = "/hiredetails/{id}")
	public Object getById(@PathVariable("id") Integer id) {
		ResponseEntity<Object> gethiredetails = service.HireObjectivefindById(id);
		return new ResponseEntity<Object>(gethiredetails, HttpStatus.OK).getBody();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteHireObjective(@PathVariable int id) {
		service.deleteHireObjective(id);
	}
//
//	@GetMapping("/hiredetails/{id}")
//	public Optional<HireObjective> findById(@PathVariable Integer id) {
//		return service.HireObjectivefindById(id);
//	}

}
