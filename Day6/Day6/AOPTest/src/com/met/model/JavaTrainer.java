package com.met.model;

import java.util.List;
import java.util.Random;

public class JavaTrainer implements Trainer {

	private String name;
	private List<String> subjects;
	
	public JavaTrainer() {
		super();
		System.out.println("JavaTrainer  :: default constructor invoked");
	}

	public JavaTrainer(String name, List<String> subjects) {
		super();
		this.name = name;
		this.subjects = subjects;
		
		System.out.println("JavaTrainer  :: Parameterized constructor invoked");
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
		
		//System.out.println("Participants are taking seat");						//Before business logic
		/*System.out.println("Participants are joining google meet");
		System.out.println("Participants are switching off mobile phones");		//Before business logic
*/		
		
		Random rnd = new Random();
		int value = rnd.nextInt();
		
		if(value < 5){
			throw new RuntimeException();
		}
		
		System.out.println(name + " is training on java subjects " + subjects);		//Business logic
			
		/*System.out.println("Training completed");								//After business logic
*/		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " is a JavaTrainer";
	}

}
