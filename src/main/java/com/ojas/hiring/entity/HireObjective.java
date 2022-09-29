package com.ojas.hiring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hireObjective")
/* @Author Shobha.Bakkathatla */
public class HireObjective {

	private int hireId;
	private String comment;
	private String author;
	private String position;

	public HireObjective(int hireId, String comment, String author, String position) {
		super();
		this.hireId = hireId;
		this.comment = comment;
		this.author = author;
		this.position = position;
	}

	public HireObjective() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Hire_id")
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

	@Column(name = "author")

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "position")

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "HireObjective [hireId=" + hireId + ", comment=" + comment + ", author=" + author + ", position="
				+ position + "]";
	}

}
