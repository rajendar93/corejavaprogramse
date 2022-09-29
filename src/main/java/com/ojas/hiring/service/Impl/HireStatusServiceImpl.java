package com.ojas.hiring.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.hiring.entity.HireStatus;
import com.ojas.hiring.repo.HireStatusRepo;
import com.ojas.hiring.service.HireStatusService;

@Service

/* @Author Shobha.Bakkathatla */
public class HireStatusServiceImpl implements HireStatusService {

	@Autowired
	HireStatusRepo repo;

	@Override
	public HireStatus saveHireStatus(HireStatus hireStatus) {
		return repo.save(hireStatus);
	}

	@Override
	public List<HireStatus> getAllHireStatus() {
		return repo.findAll();
	}

	@Override
	public void deleteHireStatus(int id) {
		repo.deleteById(id);
	}

	public ResponseEntity<Object> HireStatusfindById(Integer id) {
		Optional<HireStatus> hireStatus = repo.findById(id);
		if (hireStatus.isPresent()) {
			return new ResponseEntity<Object>(hireStatus, HttpStatus.OK);
		} else {
			String message = "Given Id is not found";
			return new ResponseEntity<Object>(message, HttpStatus.OK);
		}
	}

	@Override
	public HireStatus updaterHireStatus(HireStatus hireStatus) {
		return repo.save(hireStatus);
	}

}
