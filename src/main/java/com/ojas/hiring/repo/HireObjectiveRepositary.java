package com.ojas.hiring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.hiring.entity.HireObjective;

/* @Author Shobha.Bakkathatla */
@Repository
public interface HireObjectiveRepositary extends JpaRepository<HireObjective, Integer> {

}
