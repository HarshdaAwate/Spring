package com.met.model;

import java.util.List;

public class DotNetTrainer implements Trainer {

	private String name;
	private List<String> subjects;
	
	public DotNetTrainer() {
		super();
		System.out.println("DotNetTrainer  :: default constructor invoked");
	}

	public DotNetTrainer(String name, List<String> subjects) {
		super();
		this.name = name;
		this.subjects = subjects;
		
		System.out.println("DotNetTrainer  :: Parameterized constructor invoked");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	@Override
	public void train() {
		
		System.out.println("DotNetTrainer :: train method ");
		System.out.println(name + " is training on DotNet subjects " + subjects);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " is a DotNetTrainer";
	}

}
