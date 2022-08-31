package com.ignacio1250.examenpractico.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class RegisterWorkingHoursDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@NotNull
	private Integer employee_id;
	@NotNull
	private Integer worked_hours;
	@NotNull
	private String worked_date;
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public Integer getWorked_hours() {
		return worked_hours;
	}
	public void setWorked_hours(Integer worked_hours) {
		this.worked_hours = worked_hours;
	}
	public String getWorked_date() {
		return worked_date;
	}
	public void setWorked_date(String worked_date) {
		this.worked_date = worked_date;
	}
	
	

}
