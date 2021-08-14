package com.met.model;

public class TrainingWorkshop implements Workshop {

	private TrainingCompany trainingCompany;
	
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
