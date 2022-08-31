package com.ignacio1250.examenpractico.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="EMPLOYEES")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="GENDER_ID")
	private Gender gender;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="JOB_ID")
	private Job job;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="BIRTHDATE")
	private Date birthDate;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="employee")
	private List<EmployeeWorkedHours> employeeWorkedHours;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<EmployeeWorkedHours> getEmployeeWorkedHours() {
		return employeeWorkedHours;
	}

	public void setEmployeeWorkedHours(List<EmployeeWorkedHours> employeeWorkedHours) {
		this.employeeWorkedHours = employeeWorkedHours;
	}
	
	
}
