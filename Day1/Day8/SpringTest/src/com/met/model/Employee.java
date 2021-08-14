package com.met.model;

public class Employee {

	private int id;
	private String name;
	private int age;
	private String designation;
	private double salary = 25000;
	
	private static int count = 0;
	
	public Employee(){
		id = ++count;
		
		System.out.println("Employee object created with id: " + id);
	}
	
	public int getId() {
		return id;
	}
	/*public void setId(int id) {
		this.id = id;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", designation=" + designation + ", salary="
				+ salary + "]";
	}
	
	public double getAnnualIncome(){
		return salary * 12;
	}
	
}
