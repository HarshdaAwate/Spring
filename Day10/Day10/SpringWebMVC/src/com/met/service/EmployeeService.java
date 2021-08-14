package com.met.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.met.dao.EmployeeDAO;
import com.met.model.Employee;

//@Component
@Service
public class EmployeeService {

	//private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public void saveEmployee(Employee employee){
		
		System.out.println(employeeDAO.getClass());
		
		//perform some validation on Employee object.
		
		String emailId = employee.getEmailId();
		
		if(!emailId.contains(".") || !emailId.contains("@")){
			
			throw new RuntimeException("EmailId : " + emailId + " is invalid");
			
		}
		
		
		System.out.println("EmployeeService :: saveEmployee");
		employeeDAO.saveEmployee(employee);
		
	}
	
	public Collection<Employee> getAllEmployees(){
	
		return employeeDAO.getAllEmployees();
		
	}
	
}



