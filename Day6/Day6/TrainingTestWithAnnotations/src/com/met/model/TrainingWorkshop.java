package com.met.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*<bean id="workshop" class="com.met.model.TrainingWorkshop">*/

@Component("workshop")
/*@Scope("Singleton")
@Lazy*/
public class TrainingWorkshop implements Workshop {

	@Autowired					 /*autowire="byType"*/
	private TrainingCompany trainingCompany;
	
	/*@Autowired(required=false)
	private DataSource datasource;*/
	
	@Override
	public void conductWorkshop() {
		System.out.println("TrainingWorkshop :: conductWorkshop()");
		trainingCompany.conductTraining();
	}

	public TrainingCompany getTrainingCompany() {
		return trainingCompany;
	}

	public void setTrainingCompany(TrainingCompany trainingCompany) {
		this.trainingCompany = trainingCompany;
	}

	public TrainingWorkshop(TrainingCompany trainingCompany) {
		super();
		this.trainingCompany = trainingCompany;
		System.out.println("TrainingWorkshop :: Parameterized constructor invoked");
	}

	public TrainingWorkshop() {
		super();
		System.out.println("TrainingWorkshop :: Default constructor invoked");
	}
	
	

}
