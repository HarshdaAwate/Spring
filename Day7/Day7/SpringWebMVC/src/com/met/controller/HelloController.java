package com.met.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@Component
@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView welcome(){
		
	
		ModelAndView modelAndView = new ModelAndView();
		
		
		modelAndView.addObject("welcomeMsg", "Welcome to Spring MVC");	
																			//request.setAttribute("welcomeMsg", "");
		
		modelAndView.setViewName("hello");
		
		return modelAndView;
		
	} 
	
	//http://localhost:8055/SpringWebMVC/mvc/hello/requestParam?name=Ramesh&age=25
	//http://localhost:8055/SpringWebMVC/mvc/hello/requestParam?name=Ramesh
	//http://localhost:8055/SpringWebMVC/mvc/hello/requestParam?userName=Ramesh
	
	@RequestMapping(value="requestParam", method=RequestMethod.GET)
	public ModelAndView requestParam(@RequestParam(required=false, name="userName") String name, @RequestParam(defaultValue="28") int age){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("welcomeMsg", "Welcome to Spring MVC user : " + name + " with age " + age);	
		modelAndView.setViewName("hello");
		
		
		return modelAndView;
		
	}
	
	//http://localhost:8055/SpringWebMVC/mvc/hello/requestParam?id=15
	
	//PathVariable
	//http://localhost:8055/SpringWebMVC/mvc/hello/pathVar/15
	//http://localhost:8055/SpringWebMVC/mvc/getEmployee/15
	//http://localhost:8055/SpringWebMVC/mvc/getEmployee?id=15
	//@RequestMapping(method=RequestMethod.GET)
	
		
	@GetMapping(value="pathVar/{id}")
	public ModelAndView pathVariable(@PathVariable int id){
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("welcomeMsg", "Welcome to Spring MVC user with id: "+ id);	
		modelAndView.setViewName("hello");
		
		
		return modelAndView;
	}
	
}






