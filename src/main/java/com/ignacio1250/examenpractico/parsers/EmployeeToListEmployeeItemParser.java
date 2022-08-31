package com.ignacio1250.examenpractico.parsers;

import java.util.ArrayList;
import java.util.List;

import com.ignacio1250.examenpractico.dto.EmployeeListItemDTO;
import com.ignacio1250.examenpractico.dto.GenderDTO;
import com.ignacio1250.examenpractico.dto.JobDTO;
import com.ignacio1250.examenpractico.entities.Employee;

public class EmployeeToListEmployeeItemParser {

	public static List<EmployeeListItemDTO> parseEmployeeListToEmployeeListItemsDTO(List<Employee> employees){
		List<EmployeeListItemDTO> array = new ArrayList<EmployeeListItemDTO>();
		for(Employee employee : employees) {
			EmployeeListItemDTO employeeListItemDTO = new EmployeeListItemDTO();
			employeeListItemDTO.setId(employee.getId());
			employeeListItemDTO.setBirthdate(employee.getBirthDate().toString());
			employeeListItemDTO.setName(employee.getName());
			employeeListItemDTO.setLast_name(employee.getLastName());
			
			JobDTO jobDto = new JobDTO();
			jobDto.setId(employee.getJob().getId());
			jobDto.setName(employee.getJob().getName());
			jobDto.setSalary(employee.getJob().getSalary());
			employeeListItemDTO.setJob(jobDto);
			
			GenderDTO genderDto= new GenderDTO();
			genderDto.setId(employee.getGender().getId());
			genderDto.setName(employee.getGender().getName());
			employeeListItemDTO.setGender(genderDto);
			array.add(employeeListItemDTO);
		}
		return array;
	}
	
}
