package com.ignacio1250.examenpractico.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class FindListEmployeeByJobRequestDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@NotNull
	private Integer job_id;

	public Integer getJob_id() {
		return job_id;
	}

	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}
	
}
