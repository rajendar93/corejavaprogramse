package com.ojas.hiring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.ojas.hiring.entity.Interviews;
import com.ojas.hiring.entity.SalaryNegotiationDetails;

public interface SalaryNegDetailsService {

	public SalaryNegotiationDetails addSalaryNegDetails(SalaryNegotiationDetails salaryNegotiationDetails);

	public List<SalaryNegotiationDetails> getAllSalaryNegDetails();

	public ResponseEntity<Object> findByHireId(int hireId);

	public ResponseEntity<Object> findByToken(int id);

	public Object updateSalNegDetails(SalaryNegotiationDetails salNegDetails, int hireId);

	public ResponseEntity<Object> updatebytokenSalNegDetails(SalaryNegotiationDetails salNegDetails, int token);
	
	public void deleteSalNegDetailsByHireId(int hireId);

	public void deleteSalNegDetailsByTokenId(int tokenId);
}
