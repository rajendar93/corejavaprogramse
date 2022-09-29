package com.ojas.hiring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hires_status")

/* @Author Shobha.Bakkathatla */

public class HireStatus {

	private int hireId;
	private String comment;
	private String status;

	public HireStatus(int hireId, String comment, String status) {
		super();
		this.hireId = hireId;
		this.comment = comment;
		this.status = status;
	}

	public HireStatus() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Hire_Id")
	public int getHireId() {
		return hireId;
	}

	public void setHireId(int hireId) {
		this.hireId = hireId;
	}

	@Column(name = "comment")

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "status")

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HireStatus [hireId=" + hireId + ", comment=" + comment + ", status=" + status + "]";
	}

}
