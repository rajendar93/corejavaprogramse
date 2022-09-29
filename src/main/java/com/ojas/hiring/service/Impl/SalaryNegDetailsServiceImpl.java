package com.ojas.hiring.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ojas.hiring.entity.SalaryNegotiationDetails;
import com.ojas.hiring.repo.SalaryNegotiationDetailsRepo;
import com.ojas.hiring.service.SalaryNegDetailsService;

/*@Author Akshaya Kumar Mahanty*/

@Service
public class SalaryNegDetailsServiceImpl implements SalaryNegDetailsService {

	@Autowired
	SalaryNegotiationDetailsRepo salaryNegotiationDetailsRepo;

	@Override
	public SalaryNegotiationDetails addSalaryNegDetails(SalaryNegotiationDetails salaryNegotiationDetails) {
		return salaryNegotiationDetailsRepo.save(salaryNegotiationDetails);
	}

	@Override
	public List<SalaryNegotiationDetails> getAllSalaryNegDetails() {
		return salaryNegotiationDetailsRepo.findAll();
	}

	@Override
	public ResponseEntity<Object> findByHireId(int hireId) {
		Optional<SalaryNegotiationDetails> getHireDetails = salaryNegotiationDetailsRepo.findByHireId(hireId);
		String msg = "HireId is not found..!";
		if (getHireDetails.isEmpty()) {
			return new ResponseEntity<Object>(msg, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Object>(getHireDetails, HttpStatus.OK);
		}

	}

	@Override
	public ResponseEntity<Object> findByToken(int id) {
		Optional<SalaryNegotiationDetails> getHireDetails = salaryNegotiationDetailsRepo.findByToken(id);
		String msg = "InterviewId is not found..!";
		if (getHireDetails.isEmpty()) {
			return new ResponseEntity<Object>(msg, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Object>(getHireDetails, HttpStatus.OK);
		}

	}

	@Override
	public ResponseEntity<Object> updateSalNegDetails(SalaryNegotiationDetails salNegDetails, int hireId) {
		Optional<SalaryNegotiationDetails> findHireId = salaryNegotiationDetailsRepo.findByHireId(hireId);

		if (findHireId.isEmpty()) {
			return ResponseEntity.badRequest().body(" Please Enter valid Id...!");
		} else {
			SalaryNegotiationDetails db = salaryNegotiationDetailsRepo.findByHireId(hireId).get();

			if (salNegDetails.getBudget() == 0.0) {
				double budget = findHireId.get().getBudget();
				db.setBudget(budget);
			} else {
				db.setBudget(salNegDetails.getBudget());
			}
			if (salNegDetails.getNegotiated() == 0.0) {
				double negDetails = findHireId.get().getNegotiated();
				db.setNegotiated(negDetails);
			} else {
				db.setNegotiated(salNegDetails.getNegotiated());
			}
			if (salNegDetails.getOfferedCTC() == 0.0) {
				double offeredCTC = findHireId.get().getOfferedCTC();
				db.setOfferedCTC(offeredCTC);
			} else {
				db.setOfferedCTC(salNegDetails.getOfferedCTC());
			}

			db.setHireId(hireId);
			salaryNegotiationDetailsRepo.saveAndFlush(db);
			return new ResponseEntity<Object>(db, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<Object> updatebytokenSalNegDetails(SalaryNegotiationDetails salNegDetails, int tokenId) {
		Optional<SalaryNegotiationDetails> findHireId = salaryNegotiationDetailsRepo.findByToken(tokenId);

		if (findHireId.isEmpty()) {
			return ResponseEntity.badRequest().body(" Please Enter valid TokenId...!");
		} else {
			SalaryNegotiationDetails db = salaryNegotiationDetailsRepo.findByToken(tokenId).get();

			if (salNegDetails.getBudget() == 0.0) {
				double budget = findHireId.get().getBudget();
				db.setBudget(budget);
			} else {
				db.setBudget(salNegDetails.getBudget());
			}
			if (salNegDetails.getNegotiated() == 0.0) {
				double negDetails = findHireId.get().getNegotiated();
				db.setNegotiated(negDetails);
			} else {
				db.setNegotiated(salNegDetails.getNegotiated());
			}
			if (salNegDetails.getOfferedCTC() == 0.0) {
				double offeredCTC = findHireId.get().getOfferedCTC();
				db.setOfferedCTC(offeredCTC);
			} else {
				db.setOfferedCTC(salNegDetails.getOfferedCTC());
			}
			db.setToken(String.valueOf(tokenId));
			salaryNegotiationDetailsRepo.saveAndFlush(db);
			return new ResponseEntity<Object>(db, HttpStatus.OK);
		}
	}

	@Override
	public void deleteSalNegDetailsByHireId(int hireId) {
		salaryNegotiationDetailsRepo.deleteByHireId(hireId);

	}

	@Override
	@Transactional
	public void deleteSalNegDetailsByTokenId(int tokenId) {
		String token = String.valueOf(tokenId);
		salaryNegotiationDetailsRepo.deleteByToken(token);
		
	}

}
