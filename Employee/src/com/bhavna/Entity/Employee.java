package com.bhavna.Entity;

public class Employee {
	
	private String Name;
	private Double Salary;
	private String Location;
	public Employee(String name, Double salary, String location) {
		super();
		Name = name;
		Salary = salary;
		Location = location;
	}
	public Employee() {
		
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getSalary() {
		return Salary;
	}
	public void setSalary(Double salary) {
		Salary = salary;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	@Override
	public String toString() {
		return "Employee [Name=" + Name + ", Salary=" + Salary + ", Location=" + Location + "]";
	}
	
	
	

}
