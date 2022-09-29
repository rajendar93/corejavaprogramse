package com.ojas.hiring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.hiring.entity.Roles;

/* @Author Shobha.Bakkathatla */

@Repository
public interface RolesRepositary extends JpaRepository<Roles, Integer>{

}
