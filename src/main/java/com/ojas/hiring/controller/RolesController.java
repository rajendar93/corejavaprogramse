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

import com.ojas.hiring.entity.Roles;
import com.ojas.hiring.service.RolesService;

@RestController
@RequestMapping("/api/role")

/* @Author Shobha.Bakkathatla */

public class RolesController {

	@Autowired
	RolesService service;

	@PostMapping("/add")
	public Object saveRoles(@RequestBody Roles roles) {
		return service.saveRoles(roles);
	}

	@PutMapping("/updates/{roleId}")
	public Object updates(@RequestBody Roles roles, @PathVariable("roleId") int roleId) {
		ResponseEntity<Object> gethiredetails = service.updaterRoles(roles, roleId);
		return new ResponseEntity<Object>(gethiredetails, HttpStatus.OK).getBody();
	}

	@GetMapping("/roledetails")
	public List<Roles> getAllRoles() {
		return service.getAllRoles();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteRoles(@PathVariable int id) {
		service.deleteRoles(id);
	}

	@GetMapping("/roledetails/{id}")
	public Object getById(@PathVariable("id") Integer id) {
		ResponseEntity<Object> gethiredetails = service.rolefindById(id);
		return new ResponseEntity<Object>(gethiredetails, HttpStatus.OK).getBody();
	}
}
