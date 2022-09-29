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

import com.ojas.hiring.entity.Positions;
import com.ojas.hiring.service.Impl.PositionsService;

@RestController
@RequestMapping("/api/positions")
//@Author Rajendar.Baswaraju
public class PositionsController {
	@Autowired
	PositionsService positionsService;

	@PostMapping("/save")
	private Positions saveData(@RequestBody Positions positions) {
		return positionsService.savePositions(positions);

	}

	@GetMapping("/getall")
	private List<Positions> getData() {
		return positionsService.getAllPositions();

	}

	@DeleteMapping("/delete/{position_id}")
	private void deleteData(@PathVariable("position_id") Integer position_id) {
		positionsService.deletePosistions(position_id);
	}

	@PutMapping(value = "/updates/{id}")
	public Object update(@RequestBody Positions positions, @PathVariable int id) {
		ResponseEntity<Object> update = positionsService.update(positions, id);
		return new ResponseEntity<Object>(update, HttpStatus.ACCEPTED).getBody();
	}
}
