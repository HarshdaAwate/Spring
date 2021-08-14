package com.met.model;

import java.util.List;

public class JavaDotNetTrainer {

	private String name;
	private List<String> subjects;
	
	public JavaDotNetTrainer() {
		super();
		System.out.println("JavaDotNetTrainer  :: default constructor invoked");
	}

	public JavaDotNetTrainer(String name, List<String> subjects) {
		super();
		this.name = name;
		this.subjects = subjects;
		
		System.out.println("JavaDotNetTrainer  :: Parameterized constructor invoked");
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

	public void train() {
		
		//System.out.println("Participants are taking seat");
		/*System.out.println("Participants are joining google meet");
		System.out.println("Participants are switching off mobile phones");
		*/
		System.out.println(name + " is training on JavaDotNetTrainer subjects " + subjects);
		
		/*System.out.println("Training completed");*/
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " is a JavaDotNetTrainer";
	}


	
}
