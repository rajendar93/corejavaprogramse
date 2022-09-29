package com.ojas.hiring.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ojas.hiring.entity.SalaryNegotiationDetails;

@Repository
public interface SalaryNegotiationDetailsRepo extends JpaRepository<SalaryNegotiationDetails, Integer> {

	@Query(value = "select * from salary_negotiation_details where HIRE_ID = :HIRE_ID", nativeQuery = true)
	Optional<SalaryNegotiationDetails> findByHireId(@Param("HIRE_ID") int hireId);

	@Query(value = "select * from salary_negotiation_details where token = :ID", nativeQuery = true)
	Optional<SalaryNegotiationDetails> findByToken(@Param("ID") int id);

	@Transactional
	void deleteByHireId(int hireId);

	void deleteByToken(String token);

}
