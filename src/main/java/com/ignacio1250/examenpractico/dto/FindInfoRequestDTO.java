package com.ignacio1250.examenpractico.dto;

import java.io.Serializable;

public class FindInfoRequestDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer employee_id;
	private String start_date;
	private String end_date;
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	
	
}
