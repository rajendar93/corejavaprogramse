package com.ojas.hiring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ojas.hiring.entity.HireTable;


public interface HireTableService {

	public HireTable addInterviewDetails(HireTable hireTable);
	
	public List<HireTable> getAllInterviewDetails();
	
	public  ResponseEntity<Object> findInterviewById(int id);
	
	public  ResponseEntity<Object> findByInterviewByHireId(String hireId);

	public ResponseEntity<Object> findByInterviewByToken(String id);
		
}
