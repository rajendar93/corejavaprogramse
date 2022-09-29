package com.ojas.hiring.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ojas.hiring.entity.Interviews;
import com.ojas.hiring.entity.SalaryNegotiationDetails;
import com.ojas.hiring.repo.InterviewsRepo;
import com.ojas.hiring.service.InterviewService;

/*@Author Akshaya Kumar Mahanty*/

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	private InterviewsRepo interviewRepo;

	@Override
	public Interviews addInterviewDetails(Interviews interview) {
		return interviewRepo.save(interview);
	}

	@Override
	public List<Interviews> getAllInterviewDetails() {
		return interviewRepo.findAll();
	}

	@Override
	public ResponseEntity<Object> findByInterviewId(int id) {
		List<Interviews> getHireDetails = interviewRepo.findByInterviewId(id);
		String msg = "HireId is not found..!";
		if (getHireDetails.isEmpty()) {
			return new ResponseEntity<Object>(msg, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Object>(getHireDetails, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<Object> findBySearchHireId(String hireId) {
		List<Interviews> searchDetails = interviewRepo.findBySearchHireId(hireId);
		if (searchDetails.isEmpty()) {
			String msg = "HireId is not found..!";
			return new ResponseEntity<Object>(msg, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Object>(searchDetails, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> updateInterview(Interviews interview, int id) {
		Optional<Interviews> findId = interviewRepo.findById(id);

		if (findId.isEmpty()) {
			return ResponseEntity.badRequest().body(" Please Enter valid Id...!");
		} else {
			Interviews db = interviewRepo.findById(id).get();

			if (interview.getHireName() == null) {
				String name = findId.get().getHireName();
				db.setHireName(name);
			} else {
				db.setHireName(interview.getHireName());
			}
			if (interview.getAuthor() == null) {
				String auth = findId.get().getAuthor();
				db.setAuthor(auth);
			} else {
				db.setAuthor(interview.getAuthor());
			}
			if (interview.getAuthorRole() == null) {
				String authRole = findId.get().getAuthorRole();
				db.setAuthorRole(authRole);
			} else {
				db.setAuthorRole(interview.getAuthorRole());
			}
			if (interview.getComment() == null) {
				String comment = findId.get().getComment();
				db.setComment(comment);
			} else {
				db.setComment(interview.getComment());
			}
			if (interview.getRating() == 0) {
				int rating = findId.get().getRating();
				db.setRating(rating);
			} else {
				db.setRating(interview.getRating());
			}

			db.setId(id);
			interviewRepo.saveAndFlush(db);
			return new ResponseEntity<Object>(db, HttpStatus.OK);
		}
	}

	@Override
	public void deleteInterviewId(int id) {
		interviewRepo.deleteById(id);
		
	}

}
