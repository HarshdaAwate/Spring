package com.met.model;

public class Stage {

	private static Stage stage = null;
	
	private Stage(){
		System.out.println("Private construtor Stage object created.............");
	}
	
	public static Stage getStage(){
		
		if(stage == null){
			stage = new Stage();
		}
		
		return stage;
	}
	
}
