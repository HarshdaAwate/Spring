package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.model.Employee;

public class SpringTest {

	public static void main(String[] args) {
		
		
		
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springtest.xml");
		
		System.out.println("****************Spring /IOC Container initialization completed********************************");
		
		
		Employee emp1 = applicationContext.getBean("emp1", Employee.class);
		System.out.println("Employee with emp1 ref =" + emp1);
		System.out.println(emp1.getAnnualIncome());
		
		
		Employee emp1Singleton = applicationContext.getBean("emp1", Employee.class);
		System.out.println("Employee with emp1Singleton ref =" + emp1Singleton);
		System.out.println(emp1Singleton.getAnnualIncome());
		
		
		/*Employee employee = applicationContext.getBean(Employee.class);
		System.out.println(employee);*/
		
		Employee emp2 = applicationContext.getBean("emp2", Employee.class);
		System.out.println("Employee with id emp2: " + emp2);
		System.out.println(emp2.getAnnualIncome());
		
		
		
		Employee emp3 = applicationContext.getBean("emp3", Employee.class);
		System.out.println("Employee with id emp3: " + emp3);
		System.out.println(emp3.getAnnualIncome());
		
		Employee emp3Proto = applicationContext.getBean("emp3", Employee.class);
		System.out.println("Employee with id emp3: " + emp3Proto);
		System.out.println(emp3Proto.getAnnualIncome());
		
		Employee emp3Proto1 = applicationContext.getBean("emp3", Employee.class);
		
		Employee abc = applicationContext.getBean("emp3", Employee.class);
	}
	
}
