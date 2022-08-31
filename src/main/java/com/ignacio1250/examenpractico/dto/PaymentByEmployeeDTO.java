package com.ignacio1250.examenpractico.dto;

import java.io.Serializable;

public class PaymentByEmployeeDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer paynment;
	private Boolean success;
	public Integer getPaynment() {
		return paynment;
	}
	public void setPaynment(Integer paynment) {
		this.paynment = paynment;
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
