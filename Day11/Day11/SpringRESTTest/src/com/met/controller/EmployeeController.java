package com.met.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.met.model.Employee;
import com.met.service.EmployeeService;

//@Component
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	//private EmployeeService employeeService = new EmployeeService();
	
	@Autowired
	private EmployeeService employeeService;
	
	//http://localhost:8055/SpringWebMVC/mvc/employee
	@GetMapping
	public ModelAndView initializeEmployee(){
		
		ModelAndView modelAndView = new ModelAndView();
		
		Employee empl = new Employee();
		empl.setDesignation("FRESHER");
		
		modelAndView.addObject("employee", empl);
		
		Collection<Employee> allEmployees = employeeService.getAllEmployees();
		
		modelAndView.addObject("allEmployyes", allEmployees);
		
		
		modelAndView.setViewName("emp");
		
		return modelAndView;
		
	}
	
	
	@PostMapping
	public ModelAndView submitEmployee(@ModelAttribute Employee employee){
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("From JSP to EMployee Controller employee object details: " + employee);
		
		//write code to save employee object to db
		
		employeeService.saveEmployee(employee);
		
		
		Employee empl = new Employee();
		empl.setDesignation("FRESHER");
		
		modelAndView.addObject("employee", empl);
		
		Collection<Employee> allEmployees = employeeService.getAllEmployees();
		
		modelAndView.addObject("allEmployyes", allEmployees);
		
		modelAndView.setViewName("emp");
		
		return modelAndView;
	}
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex, HttpServletRequest request){
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("errMsg", ex.getMessage());
		modelAndView.addObject("url", request.getRequestURI());
		
		modelAndView.setViewName("error");
		
		return modelAndView;
		
	}
	
}
