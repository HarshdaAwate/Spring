package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.config.JavaConfiguration;
import com.met.model.JavaDotNetTrainer;
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
		
		
		//try(AbstractApplicationContext context = new ClassPathXmlApplicationContext("training.xml")){
		
		//ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
		
		try(AbstractApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class)){
			
			/*JavaTrainer javaTrainer = context.getBean("javaTrainer1", JavaTrainer.class);
			System.out.println(javaTrainer);
			javaTrainer.train();*/
			
			/*Trainer javaTrainer = context.getBean("javaTrainer1", Trainer.class);
			System.out.println(javaTrainer);*/
			//javaTrainer.train();
			
			Trainer javaTrainer = context.getBean("javaTrainer1", Trainer.class);
			System.out.println("javaTrainer1 spring bean id class Name: " +javaTrainer.getClass());
			
			Trainer dotNetTrainer = context.getBean("dotNetTrainer", Trainer.class);
			System.out.println("dotNetTrainer spring bean id class Name: " +dotNetTrainer.getClass());
			
			
			TrainingCompany metSolutions = context.getBean("metSolutions", TrainingCompany.class);
			System.out.println("metSolutions spring bean id class Name: " +metSolutions.getClass());
			
			//metSolutions.conductTraining();
			
			JavaDotNetTrainer jdt = context.getBean("javaDotNetTrainer", JavaDotNetTrainer.class);
			jdt.train();
			System.out.println("javaDotNetTrainer bean id classname: " + jdt.getClass());
			
			
			Workshop workshop = context.getBean("workshop", Workshop.class);
			workshop.conductWorkshop();
			
		}
		
		
		
	}
	
}
