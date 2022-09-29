package com.ojas.hiring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* @Author Akshaya.Mahanty */

@Entity
@Table(name = "salary_negotiation_details")
public class SalaryNegotiationDetails {

	private int id;
	private int hireId;
	private double budget;
	private double negotiated;
	private double offeredCTC;
	private Date createdDate;
	private String token;

	public SalaryNegotiationDetails() {
		super();
	}

	public SalaryNegotiationDetails(int id, int hireId, double budget, double negotiated, double offeredCTC, Date createdDate) {
		super();
		this.id = id;
		this.hireId = hireId;
		this.budget = budget;
		this.negotiated = negotiated;
		this.offeredCTC = offeredCTC;
		this.createdDate = createdDate;
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
	@Column(name = "HIRE_ID")
	public int getHireId() {
		return hireId;
	}

	public void setHireId(int hireId) {
		this.hireId = hireId;
	}
	@Column(name = "BUDGET")
	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	@Column(name = "NEGOTIATED")
	public double getNegotiated() {
		return negotiated;
	}

	public void setNegotiated(double negotiated) {
		this.negotiated = negotiated;
	}
	@Column(name = "OFFERED_CTC")
	public double getOfferedCTC() {
		return offeredCTC;
	}

	public void setOfferedCTC(double offeredCTC) {
		this.offeredCTC = offeredCTC;
	}
	
	@Column(name = "CREATE_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "token",unique=true,columnDefinition = "TINYTEXT")
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "SalaryNegotiationDetails [id=" + id + ", hireId=" + hireId + ", budget=" + budget + ", negotiated="
				+ negotiated + ", offeredCTC=" + offeredCTC + ", createdDate=" + createdDate + ", token=" + token + "]";
	}	

}
