package com.ojas.hiring.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.hiring.entity.HireTable;
import com.ojas.hiring.entity.Interviews;
import com.ojas.hiring.repo.HireTableRepo;
import com.ojas.hiring.service.HireTableService;

@Service
public class HireTableServiceImpl  implements HireTableService {

	@Autowired
	private HireTableRepo hireTableRepo;
	
	@Override
	public HireTable addInterviewDetails(HireTable hireTable) {
		return hireTableRepo.save(hireTable);
	}

	@Override
	public List<HireTable> getAllInterviewDetails() {
		return hireTableRepo.findAll();
	}

	@Override
	public ResponseEntity<Object> findInterviewById(int id) {
		List<HireTable> getHireDetails = hireTableRepo.findInterviewById(id);
		String msg = "Id is not found..!";
		if (getHireDetails.isEmpty()) {
			return new ResponseEntity<Object>(msg, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Object>(getHireDetails, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<Object> findByInterviewByHireId(String hireId) {
		List<HireTable> getHireDetails = hireTableRepo.findInterviewByHireId(hireId);
		String msg = "Id is not found..!";
		if (getHireDetails.isEmpty()) {
			return new ResponseEntity<Object>(msg, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Object>(getHireDetails, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<Object> findByInterviewByToken(String id) {
		List<HireTable> getHireDetails = hireTableRepo.findInterviewByToken(id);
		String msg = "Id is not found..!";
		if (getHireDetails.isEmpty()) {
			return new ResponseEntity<Object>(msg, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Object>(getHireDetails, HttpStatus.OK);
		}
	}

}
