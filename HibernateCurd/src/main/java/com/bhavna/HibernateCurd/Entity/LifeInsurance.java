package com.bhavna.HibernateCurd.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LIC")
public class LifeInsurance {
	
	
	@Id
	@Column(name="LIC_ID")
	private int id;
	
	@Column(name="POLICY_NAME")
	private String PolicyName;
	
	@Column(name = "DURATION")
	private String Duration;

	@Column(name="POLICY_ID")
	private int PolicyId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPolicyName() {
		return PolicyName;
	}

	public void setPolicyName(String policyName) {
		PolicyName = policyName;
	}

	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

	public int getPolicyId() {
		return PolicyId;
	}

	public void setPolicyId(int policyId) {
		PolicyId = policyId;
	}
	
	
	
	
	

}
