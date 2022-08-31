package com.ignacio1250.examenpractico.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ignacio1250.examenpractico.dto.CreateEmployeeDTO;
import com.ignacio1250.examenpractico.dto.CreateEmployeeResponseDTO;
import com.ignacio1250.examenpractico.dto.FindInfoRequestDTO;
import com.ignacio1250.examenpractico.dto.FindListEmployeeByJobRequestDTO;
import com.ignacio1250.examenpractico.dto.HoursWorkedResponseDTO;
import com.ignacio1250.examenpractico.dto.ListEmployeeByJobDTO;
import com.ignacio1250.examenpractico.dto.PaymentByEmployeeDTO;
import com.ignacio1250.examenpractico.dto.RegisterWorkingHoursDTO;
import com.ignacio1250.examenpractico.services.IEmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/register")
	public ResponseEntity<CreateEmployeeResponseDTO> createNewEmployee(@Valid @RequestBody CreateEmployeeDTO createEmployeeDTO){
		CreateEmployeeResponseDTO createEmployeeResponse = this.employeeService.createEmployee(createEmployeeDTO);
		return ResponseEntity.status(HttpStatus.OK).body(createEmployeeResponse);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/working-hours")
	public ResponseEntity<CreateEmployeeResponseDTO> registerWorkingHours(@Valid @RequestBody RegisterWorkingHoursDTO registerWorkingHoursDTO){
		CreateEmployeeResponseDTO createEmployeeResponse = this.employeeService.registerWorkingHours(registerWorkingHoursDTO);
		return ResponseEntity.status(HttpStatus.OK).body(createEmployeeResponse);
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/search/job")
	public ResponseEntity<ListEmployeeByJobDTO> findEmployeesByJob(@Valid @RequestBody FindListEmployeeByJobRequestDTO request){
		ListEmployeeByJobDTO listEmployees = this.employeeService.findListEmployeeByJob(request.getJob_id());
		return ResponseEntity.status(HttpStatus.OK).body(listEmployees);
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/hours-worked")
	public ResponseEntity<HoursWorkedResponseDTO> findEmployeeHoursWorkedBetweenDates(@Valid @RequestBody FindInfoRequestDTO request){
		HoursWorkedResponseDTO response = this.employeeService.findAllHoursWorkedByEmployee(request);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/total-payment")
	public ResponseEntity<PaymentByEmployeeDTO> getAcumulatedPaymentByEmployee(@Valid @RequestBody FindInfoRequestDTO request){
		PaymentByEmployeeDTO response = this.employeeService.getAcumulatedPaymentByEmployee(request);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}
