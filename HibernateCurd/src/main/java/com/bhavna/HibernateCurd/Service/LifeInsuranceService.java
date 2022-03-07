package com.bhavna.HibernateCurd.Service;

import java.util.List;

import com.bhavna.HibernateCurd.Entity.PolicyHolder;


public interface LifeInsuranceService {

	 public List<PolicyHolder> getPolicyHolders();
	 public void save(PolicyHolder policyHolder);
	 public PolicyHolder getHolderById(int thePolicyId);
	 public PolicyHolder updateHolder(int policyId , PolicyHolder policyHolder);
}
