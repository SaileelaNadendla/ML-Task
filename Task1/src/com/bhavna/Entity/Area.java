package com.bhavna.Entity;

public class Area extends State{

	
	
	public Area(String countryName, String stateName, long ZipCode) {
		super(countryName, stateName);
		this.ZipCode = ZipCode;
		
	}
	private long ZipCode;
	public long getZipCode() {
		return ZipCode;
	}
	public void setZipCode(long zipCode) {
		ZipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Area [ZipCode=" + ZipCode + "countryName=" +getCountryName() + "stateName=" + getStateName()+"]";
	}
	

	
}
