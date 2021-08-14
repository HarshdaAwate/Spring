package com.met.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*<bean id="metSolutions" class="com.met.model.METSolutions"*/

@Component("metSolutions")
public class METSolutions implements TrainingCompany {

	/*//@Autowired				
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

	@Autowired		autowire="constructor"
	public METSolutions(@Qualifier("javaTrainer1") Trainer trainer) {
		super();
		this.trainer = trainer;
		System.out.println("METSolutions ::  Parameterized constructor invoked");
	}

	@Override
	public void conductTraining() {
		System.out.println("METSolutions :: conductTraining() ");
		trainer.train();

	}*/
	
	
	//@Autowired				
		private List<Trainer> trainers;
		
		

		public List<Trainer> getTrainers() {
			return trainers;
		}

		public void setTrainers(List<Trainer> trainers) {
			this.trainers = trainers;
		}

		public METSolutions() {
			super();
			System.out.println("METSolutions ::  default constructor invoked");
		}

		@Autowired		/*autowire="constructor"*/
		public METSolutions(List<Trainer> trainers) {
			super();
			this.trainers = trainers;
			System.out.println("METSolutions ::  Parameterized constructor invoked");
		}

		@Override
		public void conductTraining() {
			System.out.println("METSolutions :: conductTraining() ");
			
			for(Trainer trainer : trainers){
				trainer.train();
			}
			
		}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "METSOlutions is a TrainingCompany";
	}

}
