package com.met.nonspring.test;

import java.util.ArrayList;
import java.util.List;

import com.met.model.JavaTrainer;
import com.met.model.METSolutions;
import com.met.model.TrainingWorkshop;

public class NonSpringTest {

	public static void main(String[] args) {
		
		JavaTrainer javaTrainer = new JavaTrainer();
		javaTrainer.setName("Ram");
		
		List<String> subjects = new ArrayList<String>();
		subjects.add("OOPS");
		subjects.add("COLLECTIONS");
		subjects.add("JDBC");
		
		javaTrainer.setSubjects(subjects);
		
		System.out.println(javaTrainer);
		
		//javaTrainer.train();
		
		
		METSolutions metSolutions = new METSolutions(javaTrainer);
		
		//metSolutions.conductTraining();
		
		TrainingWorkshop workshop = new TrainingWorkshop();
		workshop.setTrainingCompany(metSolutions);
		
		workshop.conductWorkshop();
		
		
		
		
	}
	
}
