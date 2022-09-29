package com.ojas.hiring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ojas.hiring.entity.Interviews;

public interface InterviewService {

	public Interviews addInterviewDetails(Interviews interview);
	
	public List<Interviews> getAllInterviewDetails();
	
	public  ResponseEntity<Object> findByInterviewId(int id);
	
	public  ResponseEntity<Object> findBySearchHireId(String hireId);
	
	public ResponseEntity<Object> updateInterview(Interviews interview, int id);
	
	public void deleteInterviewId(int id);
}
