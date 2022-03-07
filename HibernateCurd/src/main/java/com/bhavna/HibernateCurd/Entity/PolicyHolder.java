package com.bhavna.HibernateCurd.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="POLICYHOLDER")
public class PolicyHolder {
	
	@Id
	@Column(name="POLICY_ID")
	private int PolicyId;
	
	@Column(name="PNAME")
	private String Name;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="POLICY_ID")
	private List<LifeInsurance> insurance;

	public int getPolicyId() {
		return PolicyId;
	}

	public void setPolicyId(int policyId) {
		PolicyId = policyId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<LifeInsurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(List<LifeInsurance> insurance) {
		this.insurance = insurance;
	}
	
	
	

}
