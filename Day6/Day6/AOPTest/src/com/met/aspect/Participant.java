package com.met.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Participant {
	
	/*1 -> any acess modifier (public, private, protected, default)
	 * 2 -> It can be present in any class
	 * .. -> THis method can have any no of arguements
	 * */
	
	//public JavaTrainer.train()
	@Pointcut("execution(* *.train(..))")
	public void training(){}
	
	@Before("training()")										//Create DB connection
	public void joiningGmeet(){
		System.out.println("Participants are joining google meet");
	}
	
	@Before("training()")										//Create PreparedStatment
	public void switchOffPhones(){
		System.out.println("Participants are switching off mobile phones");
	}
	
	
	@After("training()")
	public void trainingCompleted(){
		System.out.println("Training is completed");				//finally block; close any db resources
	}
	
	
	@AfterThrowing("training()")
	public void trainingFailure(){
		System.out.println("Training was failure");			//rollback tx
	}
	
	@AfterReturning("training()")
	public void trainingSucess(){
		System.out.println("Training was sucess !!");				//trsaction commit
	}
	
}












