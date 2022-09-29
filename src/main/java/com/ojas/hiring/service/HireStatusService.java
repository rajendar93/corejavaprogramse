package com.ojas.hiring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ojas.hiring.entity.HireStatus;


/* @Author Shobha.Bakkathatla */

public interface HireStatusService {

	public HireStatus saveHireStatus(HireStatus hireStatus);

	public HireStatus updaterHireStatus(HireStatus hireStatus);

	public List<HireStatus> getAllHireStatus();

	public void deleteHireStatus(int id);

	public ResponseEntity<Object> HireStatusfindById(Integer id);

}
