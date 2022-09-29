package com.ojas.hiring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ojas.hiring.entity.Roles;

/* @Author Shobha.Bakkathatla */

public interface RolesService {

	public ResponseEntity<Object> saveRoles(Roles roles);

	public ResponseEntity<Object> updaterRoles(Roles roles, Integer roleId);

	public List<Roles> getAllRoles();

	public void deleteRoles(int id);

	public ResponseEntity<Object> rolefindById(Integer roleId);

}
