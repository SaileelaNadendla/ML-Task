package com.bhavna.Entity;

public class Country {
	
	private String CountryName;
//	private int CountryPhoneCode;
	
	public Country(String countryName) {
		super();
		CountryName = countryName;
		//CountryPhoneCode = countryPhoneCode;
	}

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

//	public int getCountryPhoneCode() {
//		return CountryPhoneCode;
//	}
//
//	public void setCountryPhoneCode(int countryPhoneCode) {
//		CountryPhoneCode = countryPhoneCode;
//	}

	@Override
	public String toString() {
		return "Country [CountryName=" + CountryName + "]";
	}
	
	
	

}
