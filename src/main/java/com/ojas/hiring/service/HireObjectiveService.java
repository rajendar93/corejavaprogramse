package com.ojas.hiring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ojas.hiring.entity.HireObjective;


/* @Author Shobha.Bakkathatla */

public interface HireObjectiveService {

	public HireObjective saveHireObjective(HireObjective hireobjective);

	public HireObjective updaterHireObjective(HireObjective hireobjective);

	public List<HireObjective> getAllHireObjective();

	public void deleteHireObjective(int id);

	public ResponseEntity<Object> HireObjectivefindById(Integer id);

}
