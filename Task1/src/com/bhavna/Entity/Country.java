package com.bhavna.Entity;

public class Country {
	
	private String CountryName;
	
	
	public Country(String countryName) {
		super();
		CountryName = countryName;
		
	}

	public Country() {
	
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}


	@Override
	public String toString() {
		return "Country [CountryName=" + CountryName + "]";
	}
	
	
	

}
