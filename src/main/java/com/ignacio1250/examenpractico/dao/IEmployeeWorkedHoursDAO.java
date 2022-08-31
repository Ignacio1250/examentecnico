package com.ignacio1250.examenpractico.dao;


import com.ignacio1250.examenpractico.entities.Employee;
import com.ignacio1250.examenpractico.entities.EmployeeWorkedHours;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IEmployeeWorkedHoursDAO extends CrudRepository <EmployeeWorkedHours,Integer> {

	public EmployeeWorkedHours findByEmployeeAndWorkedDate(Employee employee,Date workedDate);
	@Query("select sum(ew.workedHours) from  EmployeeWorkedHours ew where ew.employee=:employee and ew.workedDate between :startDate and :endDate")
	public Integer findSumOfHoursByEmployeeAndDates(Employee employee,Date startDate,Date endDate);
}
