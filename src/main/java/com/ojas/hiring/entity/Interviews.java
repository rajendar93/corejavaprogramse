package com.ojas.hiring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* @Author Akshaya.Mahanty */

@Entity(name ="interviews")
@Table(name = "interviews")
/*
@Table(name = "interviews",
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"hireId", "hire_name"})
)*/
public class Interviews {
	
	private int id;
	private String hireId;
	private String comment;	
	private String author;
	private String authorRole;
	private int rating;
	private Date commentedOn;
	private String hireName;
	
	public Interviews() {
		super();
	}

	public Interviews(int id, String hireId, String comment, String author, String authorRole, int rating,
			Date commentedOn,String hireName) {
		super();
		this.id = id;
		this.hireId = hireId;
		this.comment = comment;
		this.author = author;
		this.authorRole = authorRole;
		this.rating = rating;
		this.commentedOn = commentedOn;
		this.hireName = hireName;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "hireId")
	public String getHireId() {
		return hireId;
	}

	public void setHireId(String hireId) {
		this.hireId = hireId;
	}

	@Column(name="comment", columnDefinition = "MEDIUMTEXT")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	@Column(name = "AUTHOR")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	@Column(name = "AUTHOR_ROLE")
	public String getAuthorRole() {
		return authorRole;
	}

	public void setAuthorRole(String authorRole) {
		this.authorRole = authorRole;
	}
	@Column(name = "RATING")
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	@Column(name = "COMMENTED_ON")
	public Date getCommentedOn() {
		return commentedOn;
	}

	public void setCommentedOn(Date commentedOn) {
		this.commentedOn = commentedOn;
	}
	
	@Column(name = "HIRE_NAME")
	public String getHireName() {
		return hireName;
	}

	public void setHireName(String hireName) {
		this.hireName = hireName;
	}

	@Override
	public String toString() {
		return "Interviews [id=" + id + ", hireId=" + hireId + ", comment=" + comment + ", author=" + author
				+ ", authorRole=" + authorRole + ", rating=" + rating + ", commentedOn=" + commentedOn + ", hireName="
				+ hireName + "]";
	}
	
}
