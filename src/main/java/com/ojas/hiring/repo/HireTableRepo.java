package com.ojas.hiring.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ojas.hiring.entity.HireTable;



public interface HireTableRepo  extends JpaRepository<HireTable, Integer> {	
	
	@Query(value = "select * FROM hire_table  where hid=?1 order by published_date desc", nativeQuery = true)
	List<HireTable> findInterviewById(@Param("id") int id);	
	
	@Query(value = "select * FROM hire_table  where hireId=?1 order by published_date desc", nativeQuery = true)
	List<HireTable> findInterviewByHireId(@Param("id") String hireId);
	
	@Query(value = "select * FROM hire_table  where token=?1 order by published_date desc", nativeQuery = true)
	List<HireTable> findInterviewByToken(@Param("id") String id);

}
