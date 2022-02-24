package com.bhavna.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMP")

public class EMP implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EMPID")
	 private Integer empid;
	
	@Column(name="EMPNAME")
	 private String ename;
	
	@Column(name="ESAL")
	 private Double esal;
	
	@Column(name="DOJ")
	 private String Doj;
	
	@Column(name="DEPTID")
	 private Integer DeptId;
	
	@Column(name="SATUS")
	 private String status;

	
	public EMP(Integer empid, String ename, Double esal, String doj, Integer deptId, String status) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.esal = esal;
		Doj = doj;
		DeptId = deptId;
		this.status = status;
	}
	
	public EMP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Double getEsal() {
		return esal;
	}
	public void setEsal(Double esal) {
		this.esal = esal;
	}
	public String getDoj() {
		return Doj;
	}
	public void setDoj(String doj) {
		Doj = doj;
	}
	public Integer getDeptId() {
		return DeptId;
	}
	public void setDeptId(Integer deptId) {
		DeptId = deptId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "EMP [empid=" + empid + ", ename=" + ename + ", esal=" + esal + ", Doj=" + Doj + ", DeptId=" + DeptId
				+ ", status=" + status + "]";
	}
	
	 

}
