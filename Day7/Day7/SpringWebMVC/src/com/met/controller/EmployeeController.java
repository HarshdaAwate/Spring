package com.met.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.met.model.Employee;

//@Component
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@GetMapping
	public ModelAndView initializeEmployee(){
		
		ModelAndView modelAndView = new ModelAndView();
		
		Employee empl = new Employee();
		empl.setDesignation("FRESHER");
		
		modelAndView.addObject("employee", empl);
		
		
		
		
		modelAndView.setViewName("emp");
		
		return modelAndView;
		
	}
	
	
	@PostMapping
	public ModelAndView submitEmployee(@ModelAttribute Employee employee){
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println(employee);
		
		//write code to save employee object to db
		
		modelAndView.setViewName("emp");
		
		return modelAndView;
	}
	

}
