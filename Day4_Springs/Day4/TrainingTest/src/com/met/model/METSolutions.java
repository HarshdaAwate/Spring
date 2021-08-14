package com.met.model;

public class METSolutions implements TrainingCompany {

	private Trainer trainer;
	
	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public METSolutions() {
		super();
		System.out.println("METSolutions ::  default constructor invoked");
	}

	public METSolutions(Trainer trainer) {
		super();
		this.trainer = trainer;
		System.out.println("METSolutions ::  Parameterized constructor invoked");
	}

	@Override
	public void conductTraining() {
		System.out.println("METSolutions :: conductTraining() ");
		trainer.train();

	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "METSOlutions is a TrainingCompany";
	}

}
