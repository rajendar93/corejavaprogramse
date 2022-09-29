package com.ojas.hiring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.hiring.entity.HireStatus;


/* @Author Shobha.Bakkathatla */

@Repository
public interface HireStatusRepo extends JpaRepository<HireStatus, Integer> {

}
