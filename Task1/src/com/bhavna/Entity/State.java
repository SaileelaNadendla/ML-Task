package com.bhavna.Entity;

public class State  extends Country{
	
	
	private String StateName;

	public String getStateName() {
		return StateName;
	}

	public void setStateName(String stateName) {
		StateName = stateName;
	}

	
		

	public State(String countryName, String stateName) {
		super(countryName);
		this.StateName= stateName;
		
	
	}

	
	
	
	

}
