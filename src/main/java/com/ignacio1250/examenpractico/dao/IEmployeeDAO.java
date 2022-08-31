package com.ignacio1250.examenpractico.dao;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ignacio1250.examenpractico.entities.Employee;
import com.ignacio1250.examenpractico.entities.Job;

@Repository
public interface IEmployeeDAO extends CrudRepository<Employee,Integer>{

	public Employee findEmployeeByNameAndLastName(String name,String lastName);
	public List<Employee> findEmployeeByJob(Job job);
}
