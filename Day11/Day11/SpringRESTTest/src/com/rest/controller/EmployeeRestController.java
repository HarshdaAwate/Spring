package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.met.model.Employee;
import com.met.service.EmployeeService;

//@Controller
@RestController			//@Controller  + @ResponseBody 
@RequestMapping("/welcome")
public class EmployeeRestController {

	/*@GetMapping
	public @ResponseBody String greetings(){
		return "Welcome to Spring REST services";
	}*/
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public String greetings(){
		return "Welcome to Spring REST services";
	}
	
	@GetMapping(value="getEmp/{id}", produces={MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
	})
	public Employee getEmployee(@PathVariable int id){
		
		return employeeService.getEmployee(id);
		
	}
	
	@PostMapping(value="saveEmp", consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public String saveEmployee(@RequestBody Employee employee){
		
		employeeService.saveEmployee(employee);
		
		return "success";
	}
	
	/*@GetMapping(value="getXMLEmp/{id}", produces=MediaType.APPLICATION_XML_VALUE)
	public Employee getXMLEmployee(@PathVariable int id){
		
		return employeeService.getEmployee(id);
		
	}*/
	
}







