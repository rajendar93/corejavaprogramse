package com.ojas.hiring.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.hiring.entity.HireObjective;
import com.ojas.hiring.repo.HireObjectiveRepositary;
import com.ojas.hiring.service.HireObjectiveService;

@Service
public class HireObjectiveServiceImpl implements HireObjectiveService {

	@Autowired
	HireObjectiveRepositary repo;

	public HireObjective saveHireObjective(HireObjective hireobjective) {
		return repo.save(hireobjective);
	}

	public List<HireObjective> getAllHireObjective() {
		return repo.findAll();
	}

	public void deleteHireObjective(int id) {
		repo.deleteById(id);
	}

	public ResponseEntity<Object> HireObjectivefindById(Integer id) {
		Optional<HireObjective> HireObjective = repo.findById(id);
		if (HireObjective.isPresent()) {
			return new ResponseEntity<Object>(HireObjective, HttpStatus.OK);
		} else {
			String message = "Given Id is not found";
			return new ResponseEntity<Object>(message, HttpStatus.OK);
		}
	}

	@Override
	public HireObjective updaterHireObjective(HireObjective hireobjective) {
		// TODO Auto-generated method stub
		return repo.save(hireobjective);

	}

}
