package com.ignacio1250.examenpractico.services;


import com.ignacio1250.examenpractico.dto.CreateEmployeeDTO;
import com.ignacio1250.examenpractico.dto.CreateEmployeeResponseDTO;
import com.ignacio1250.examenpractico.dto.FindInfoRequestDTO;
import com.ignacio1250.examenpractico.dto.HoursWorkedResponseDTO;
import com.ignacio1250.examenpractico.dto.ListEmployeeByJobDTO;
import com.ignacio1250.examenpractico.dto.PaymentByEmployeeDTO;
import com.ignacio1250.examenpractico.dto.RegisterWorkingHoursDTO;

public interface IEmployeeService {
	
	public CreateEmployeeResponseDTO createEmployee(CreateEmployeeDTO createEmployeeDTO);
	public CreateEmployeeResponseDTO registerWorkingHours(RegisterWorkingHoursDTO registerWorkingHoursDTO);
	public ListEmployeeByJobDTO findListEmployeeByJob(Integer jobId);
	public HoursWorkedResponseDTO findAllHoursWorkedByEmployee(FindInfoRequestDTO findHoursWorkedRequestDTO);
	public PaymentByEmployeeDTO   getAcumulatedPaymentByEmployee(FindInfoRequestDTO findPayment);
}
