package com.ignacio1250.examenpractico.dto;

import java.io.Serializable;

public class HoursWorkedResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer total_worked_hours;
	private Boolean success;
	public Integer getTotal_worked_hours() {
		return total_worked_hours;
	}
	public void setTotal_worked_hours(Integer total_worked_hours) {
		this.total_worked_hours = total_worked_hours;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
