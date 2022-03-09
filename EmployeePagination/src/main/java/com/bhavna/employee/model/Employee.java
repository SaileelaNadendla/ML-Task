package com.bhavna.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employees")

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Emp_Id")
	private Integer id;
	
	@Column(name="Emp_Name")
	private String Name;
	
	@Column(name="Emp_Age")
	private Integer Age;
	
	@Column(name="Emp_Salary")
	private Double Salary;
	
	@Column(name="Emp_Job")
	private String Jobtitle;
	
	@Column(name="Emp_Gender")
	private String Gender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	public String getJobtitle() {
		return Jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		Jobtitle = jobtitle;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Employee() {
		super();
	}

	public Employee(Integer id, String name, Integer age, Double salary, String jobtitle, String gender) {
		super();
		this.id = id;
		this.Name = name;
		this.Age = age;
		this.Salary = salary;
		this.Jobtitle = jobtitle;
		this.Gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", Name=" + Name + ", Age=" + Age + ", Salary=" + Salary + ", Jobtitle="
				+ Jobtitle + ", Gender=" + Gender + "]";
	}
	
	
	
	
	
	
	
	

}
