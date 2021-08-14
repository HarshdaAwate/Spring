package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.model.JavaTrainer;
import com.met.model.Trainer;
import com.met.model.TrainingCompany;
import com.met.model.Workshop;

public class SpringTrainingTest {

	public static void main(String[] args) {
		
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("training.xml");
		context.close();
		**/
		
		
		/*AbstractApplicationContext context = new ClassPathXmlApplicationContext("training.xml");
		context.close();*/
		
		
		try(AbstractApplicationContext context = new ClassPathXmlApplicationContext("training.xml")){
			
			/*JavaTrainer javaTrainer = context.getBean("javaTrainer1", JavaTrainer.class);
			System.out.println(javaTrainer);
			javaTrainer.train();*/
			
			Trainer javaTrainer = context.getBean("javaTrainer1", Trainer.class);
			System.out.println(javaTrainer);
			//javaTrainer.train();
			
			TrainingCompany metSolutions = context.getBean("metSolutions", TrainingCompany.class);
			//metSolutions.conductTraining();
			
			
			Workshop workshop = context.getBean("workshop", Workshop.class);
			workshop.conductWorkshop();
			
			
		}
		
		
		
	}
	
}
