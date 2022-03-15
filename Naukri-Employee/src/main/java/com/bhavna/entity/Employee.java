package com.bhavna.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Emp_Cloud")
public class Employee {
	
	@Column(name = "EMPID")
	private int empid;
	@Id
	@Column(name = "EMPNAME", unique = true)
	private String empName;
	@Column(name = "EMAIL")
	private String email;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee() {
		
	}
	public Employee(int empid, String empName, String email) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empName=" + empName + ", email=" + email + "]";
	}
	
	

}
