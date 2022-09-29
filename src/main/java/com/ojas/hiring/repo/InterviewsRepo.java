package com.ojas.hiring.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ojas.hiring.entity.Interviews;

@Repository
public interface InterviewsRepo extends JpaRepository<Interviews, Integer> {

	//@Query(value = "select * from interviews where HIRE_ID = :HIRE_ID",nativeQuery = true)
	Optional<Interviews> findByHireId(int hireId);
	
	@Query(value = "select * FROM interviews  where hire_id like :HIRE_ID% order by commented_On desc", nativeQuery = true)
	List<Interviews> findBySearchHireId(@Param("HIRE_ID") String hireId);
	
	@Query(value = "select * FROM interviews  where id=?", nativeQuery = true)
	List<Interviews> findByInterviewId(@Param("id") int id);
	
//	@Query(value = "FROM interviews  where hireId like :HIRE_ID% order by commentedOn desc")
//	List<Interviews> findBySearchHireIdJPQL(@Param("HIRE_ID") String hireId);
	
//	@Query("select a.HIRE_NAME from interviews a where a.HIRE_NAME like ?1%")
//    List<String> findNames(String id);

}
