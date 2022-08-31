package com.ignacio1250.examenpractico.dto;

import java.io.Serializable;
import java.util.List;

public class ListEmployeeByJobDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<EmployeeListItemDTO> employees;
	private Boolean success;
	
	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<EmployeeListItemDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeListItemDTO> employees) {
		this.employees = employees;
	}
	
}
