package com.ojas.hiring.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hireTable")
/* @Author RavindranathGV */

public class HireTable {
	
	private int hid;
	private String hireId;
	private String comment;
	private String interviewer;
	private String roleDescription;
	private int rating;
	private String status;
	private java.sql.Date publishedDate;
	private String token;

	
	
	public HireTable(int hid, String hireId, String comment, String role, String roleDescription, int rating,
			String status) {
		super();
		this.hid = hid;
		this.hireId = hireId;
		this.comment = comment;
		this.interviewer = role;
		this.roleDescription = roleDescription;
		this.rating = rating;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hid", unique = true, nullable = false)
	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	@Column(name = "hire_id")
	public String getHireId() {
		return hireId;
	}

	public void setHireId(String hireId) {
		this.hireId = hireId;
	}
	
	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "interviewer")
	public String getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	@Column(name = "role_description")
	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	@Column(name = "rating")
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "published_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public java.sql.Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(java.sql.Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Column(name = "token",columnDefinition = "TINYTEXT")
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "HireTable [hid=" + hid + ", hireId=" + hireId + ", comment=" + comment + ", interviewer=" + interviewer
				+ ", roleDescription=" + roleDescription + ", rating=" + rating + ", status=" + status
				+ ", publishedDate=" + publishedDate + ", token=" + token + "]";
	}

	public HireTable() {
		
	}
	
	
}
