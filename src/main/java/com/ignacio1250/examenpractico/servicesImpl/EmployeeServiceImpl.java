package com.ignacio1250.examenpractico.servicesImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignacio1250.examenpractico.dao.IEmployeeDAO;
import com.ignacio1250.examenpractico.dao.IEmployeeWorkedHoursDAO;
import com.ignacio1250.examenpractico.dao.IGenderDAO;
import com.ignacio1250.examenpractico.dao.IJobDAO;
import com.ignacio1250.examenpractico.dto.CreateEmployeeDTO;
import com.ignacio1250.examenpractico.dto.CreateEmployeeResponseDTO;
import com.ignacio1250.examenpractico.dto.FindInfoRequestDTO;
import com.ignacio1250.examenpractico.dto.HoursWorkedResponseDTO;
import com.ignacio1250.examenpractico.dto.ListEmployeeByJobDTO;
import com.ignacio1250.examenpractico.dto.PaymentByEmployeeDTO;
import com.ignacio1250.examenpractico.dto.RegisterWorkingHoursDTO;
import com.ignacio1250.examenpractico.entities.Employee;
import com.ignacio1250.examenpractico.entities.EmployeeWorkedHours;
import com.ignacio1250.examenpractico.entities.Gender;
import com.ignacio1250.examenpractico.entities.Job;
import com.ignacio1250.examenpractico.parsers.EmployeeToListEmployeeItemParser;
import com.ignacio1250.examenpractico.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private IEmployeeDAO employeeDao;
	
	@Autowired
	private IGenderDAO genderDao;
	
	@Autowired
	private IEmployeeWorkedHoursDAO employeeWorkedHoursDao;
	
	@Autowired
	private IJobDAO jobDao;

	@Override
	public CreateEmployeeResponseDTO createEmployee(CreateEmployeeDTO createEmployeeDTO) {
		CreateEmployeeResponseDTO createEmployeeResponse = new CreateEmployeeResponseDTO();
		createEmployeeResponse.setId(null);
		createEmployeeResponse.setSucces(false);
		Employee employee = this.employeeDao.findEmployeeByNameAndLastName(createEmployeeDTO.getName(),createEmployeeDTO.getLast_name());
		if(employee==null){
			employee = new Employee();
			Date dateBirth;
			try {
				dateBirth = this.parseDateStr(createEmployeeDTO.getBirthdate());
				int age = getDiffYears(dateBirth,Calendar.getInstance().getTime());
				Gender gender = this.genderDao.findById(createEmployeeDTO.getGender_id()).orElse(null);
				Job job = this.jobDao.findById(createEmployeeDTO.getJob_id()).orElse(null);
				if(age>18 && gender!=null && job!=null) {	
						employee.setBirthDate(dateBirth);
						employee.setName(createEmployeeDTO.getName());
						employee.setLastName(createEmployeeDTO.getLast_name());
						employee.setGender(gender);
						employee.setJob(job);
						employee = this.employeeDao.save(employee);
						createEmployeeResponse.setId(employee.getId());
						createEmployeeResponse.setSucces(true);		
				}
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return createEmployeeResponse;
	}
	
	private  int getDiffYears(Date first, Date last) {
	    Calendar a = getCalendar(first);
	    Calendar b = getCalendar(last);
	    int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
	    if (a.get(Calendar.DAY_OF_YEAR) > b.get(Calendar.DAY_OF_YEAR)) {
	        diff--;
	    }
	    return diff;
	}
	
	public static Calendar getCalendar(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    return cal;
	}

	@Override
	public CreateEmployeeResponseDTO registerWorkingHours(RegisterWorkingHoursDTO registerWorkingHoursDTO) {
		CreateEmployeeResponseDTO createEmployeeResponse = new CreateEmployeeResponseDTO();
		createEmployeeResponse.setId(null);
		createEmployeeResponse.setSucces(false);
		Employee employee = this.employeeDao.findById(registerWorkingHoursDTO.getEmployee_id()).orElse(null);
		try {
			Date date = this.parseDateStr(registerWorkingHoursDTO.getWorked_date());
			Date currentDate = Calendar.getInstance().getTime();
			int diff = currentDate.compareTo(date);
			if(diff==1) {
				EmployeeWorkedHours employeeWorkedHours = this.employeeWorkedHoursDao.findByEmployeeAndWorkedDate(employee, date);
				if(employeeWorkedHours==null) {
					if(employee!=null && registerWorkingHoursDTO.getWorked_hours()<=20) {
						EmployeeWorkedHours newEmployeeWorkedHours = new EmployeeWorkedHours();
						newEmployeeWorkedHours.setEmployee(employee);
						newEmployeeWorkedHours.setWorkedDate(date);
						newEmployeeWorkedHours.setWorkedHours(registerWorkingHoursDTO.getWorked_hours());
						newEmployeeWorkedHours=this.employeeWorkedHoursDao.save(newEmployeeWorkedHours);
						createEmployeeResponse.setId(newEmployeeWorkedHours.getId());
						createEmployeeResponse.setSucces(true);
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return createEmployeeResponse;
	}
	
	private Date parseDateStr(String date) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	}

	@Override
	public ListEmployeeByJobDTO findListEmployeeByJob(Integer jobId) {
		ListEmployeeByJobDTO listEmployeeByJobDTO = new ListEmployeeByJobDTO();
		Job job = this.jobDao.findById(jobId).orElse(null);
		listEmployeeByJobDTO.setSuccess(false);
		if(job!=null) {
			List<Employee> employees = this.employeeDao.findEmployeeByJob(job);
			listEmployeeByJobDTO.setEmployees(EmployeeToListEmployeeItemParser.parseEmployeeListToEmployeeListItemsDTO(employees));
			listEmployeeByJobDTO.setSuccess(true);
		}else {
			listEmployeeByJobDTO.setEmployees(new ArrayList<>());
		}
		return listEmployeeByJobDTO;
	}

	@Override
	public HoursWorkedResponseDTO findAllHoursWorkedByEmployee(FindInfoRequestDTO findHoursWorkedRequestDTO) {
		HoursWorkedResponseDTO hoursWorkedResponseDTO = new HoursWorkedResponseDTO();
		hoursWorkedResponseDTO.setSuccess(false);
		hoursWorkedResponseDTO.setTotal_worked_hours(null);
		Employee employee = this.employeeDao.findById(findHoursWorkedRequestDTO.getEmployee_id()).orElse(null);
		try {
			Date startDate = this.parseDateStr(findHoursWorkedRequestDTO.getStart_date());
			Date endDate = this.parseDateStr(findHoursWorkedRequestDTO.getEnd_date());
			int diff = endDate.compareTo(startDate);
			if(employee!=null && diff>=0) {
				Integer totalHours = this.employeeWorkedHoursDao.findSumOfHoursByEmployeeAndDates(employee, startDate,endDate);
				if(totalHours==null) {
					totalHours =0;
				}
				hoursWorkedResponseDTO.setSuccess(true);
				hoursWorkedResponseDTO.setTotal_worked_hours(totalHours);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return hoursWorkedResponseDTO;
	}

	@Override
	public PaymentByEmployeeDTO getAcumulatedPaymentByEmployee(FindInfoRequestDTO findPayment) {
		PaymentByEmployeeDTO paymentByEmployeeDTO = new PaymentByEmployeeDTO();
		paymentByEmployeeDTO.setPaynment(null);
		paymentByEmployeeDTO.setSuccess(false);
		Employee employee = this.employeeDao.findById(findPayment.getEmployee_id()).orElse(null);
		HoursWorkedResponseDTO hoursWorkedResponseDTO=this.findAllHoursWorkedByEmployee(findPayment);
		if(hoursWorkedResponseDTO.getTotal_worked_hours()!=null) {
			Integer totalHours = hoursWorkedResponseDTO.getTotal_worked_hours();
			paymentByEmployeeDTO.setPaynment(totalHours*employee.getJob().getSalary());
			paymentByEmployeeDTO.setSuccess(true);	
		}
		
		return paymentByEmployeeDTO;
	}

}
