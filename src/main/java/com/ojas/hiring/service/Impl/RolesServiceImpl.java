package com.ojas.hiring.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.hiring.entity.Roles;
import com.ojas.hiring.repo.RolesRepositary;
import com.ojas.hiring.service.RolesService;

@Service

/* @Author Shobha.Bakkathatla */
public class RolesServiceImpl implements RolesService {

	@Autowired
	RolesRepositary repo;

	@Override
	public ResponseEntity<Object> saveRoles(Roles roles) {

		Optional<Roles> roleDetail = repo.findById(roles.getRoleId());
		if (roleDetail.isPresent()) {
			String message = "Given role is Already present";
			return new ResponseEntity<Object>(message, HttpStatus.OK);
		}

		Roles hireStatus = repo.save(roles);
		return new ResponseEntity<Object>(hireStatus, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> updaterRoles(Roles roles, Integer roleId) {
		Optional<Roles> roleDetail = repo.findById(roleId);
		Roles updaterRoles = new Roles();
		if (roleDetail.isEmpty()) {
			String message = "Given role id is not present";
			return new ResponseEntity<Object>(message, HttpStatus.OK);
		} else {
			if (roles.getRoleId() == null) {
				updaterRoles.setRoleId(roleDetail.get().getRoleId());
			} else {
				updaterRoles.setRoleId(roles.getRoleId());
			}
			if (roles.getRoleName() == null) {
				updaterRoles.setRoleName(roleDetail.get().getRoleName());
			} else {
				updaterRoles.setRoleName(roles.getRoleName());
			}

		}
		repo.save(updaterRoles);
		return new ResponseEntity<Object>(updaterRoles, HttpStatus.OK);

	}

	@Override
	public List<Roles> getAllRoles() {

		return repo.findAll();
	}

	@Override
	public void deleteRoles(int id) {
		repo.deleteById(id);
	}

	@Override
	public ResponseEntity<Object> rolefindById(Integer id) {
		Optional<Roles> hireStatus = repo.findById(id);
		if (hireStatus.isPresent()) {
			return new ResponseEntity<Object>(hireStatus, HttpStatus.OK);
		} else {
			String message = "Given hireid is not found";
			return new ResponseEntity<Object>(message, HttpStatus.OK);
		}
	}

}
