package com.ignacio1250.examenpractico.dto;

import java.io.Serializable;

public class CreateEmployeeResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean succes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getSucces() {
		return succes;
	}
	public void setSucces(Boolean succes) {
		this.succes = succes;
	}
	
	

}
