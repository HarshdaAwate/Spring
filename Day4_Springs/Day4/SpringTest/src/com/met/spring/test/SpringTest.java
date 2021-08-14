package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.model.Address;
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
		
		
		
		System.out.println("************************Start -- Scope prototype*********************");
		
		Employee emp3 = applicationContext.getBean("emp3", Employee.class);
		System.out.println("Employee with id emp3: " + emp3);
		System.out.println(emp3.getAnnualIncome());
		
		Employee emp3Proto = applicationContext.getBean("emp3", Employee.class);
		System.out.println("Employee with id emp3: " + emp3Proto);
		System.out.println(emp3Proto.getAnnualIncome());
		
		Employee emp3Proto1 = applicationContext.getBean("emp3", Employee.class);
		
		Employee abc = applicationContext.getBean("emp3", Employee.class);
		
		System.out.println("*********************End -- Scope prototype*********************");
		
		
		Employee emp4 = applicationContext.getBean("emp4", Employee.class);
		System.out.println("Employee with id emp4: " + emp4);
		System.out.println(emp4.getAnnualIncome());
		
		
		Employee emp5 = applicationContext.getBean("emp5", Employee.class);
		System.out.println("Employee with id emp5: " + emp5);
		System.out.println(emp5.getAnnualIncome());
		
		Employee emp6 = applicationContext.getBean("emp6", Employee.class);
		System.out.println("Employee with id emp6: " + emp6);
		System.out.println(emp6.getAnnualIncome());
		
		Employee emp7 = applicationContext.getBean("emp7", Employee.class);
		System.out.println("Employee with id emp7: " + emp7);
		System.out.println(emp7.getAnnualIncome());
		
		System.out.println("-----------------------------lazy-init true-------------------------");
		
		Employee emp8 = applicationContext.getBean("emp8", Employee.class);
		System.out.println("Employee with id emp8: " + emp8);
		System.out.println(emp8.getAnnualIncome());
		
		Employee emp8Singleton = applicationContext.getBean("emp8", Employee.class);
		System.out.println("Employee with id emp8: " + emp8Singleton);
		System.out.println(emp8Singleton.getAnnualIncome());
		
		System.out.println("-----------------------------End lazy-init true-------------------------");
		
		
		Address address = applicationContext.getBean("address1", Address.class);
		System.out.println(address);
		
		
	}
	
}
