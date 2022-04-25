package com.bhavna.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customers_Angular")
public class Customer {

	@Id

	@Column(name = "customerId")
	private Integer customerId;

	@Column(name = "customerName")
	private String customerName;
	
	@Column(name = "dob")
	private Date dob;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "address")
	private String Address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "pincode")
	private Integer pincode;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId, String customerName, Date dob, Gender gender, String address, String city,
			String country, Integer pincode) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.dob = dob;
		this.gender = gender;
		Address = address;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", dob=" + dob + ", gender="
				+ gender + ", Address=" + Address + ", city=" + city + ", country=" + country + ", pincode=" + pincode
				+ "]";
	}

		
}
