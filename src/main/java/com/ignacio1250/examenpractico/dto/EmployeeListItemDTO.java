package com.ignacio1250.examenpractico.dto;

import java.io.Serializable;

public class EmployeeListItemDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String last_name;
	private String birthdate;
	private JobDTO job;
	private GenderDTO gender;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public JobDTO getJob() {
		return job;
	}
	public void setJob(JobDTO job) {
		this.job = job;
	}
	public GenderDTO getGender() {
		return gender;
	}
	public void setGender(GenderDTO gender) {
		this.gender = gender;
	}
	
}
