package com.bhavna.HibernateCurd.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.HibernateCurd.Dao.PolicyHolderDao;
import com.bhavna.HibernateCurd.Entity.PolicyHolder;

@Service
public class LifeInsuranceImpl implements LifeInsuranceService{
	
	@Autowired
	public PolicyHolderDao dao;

	@Override
	@Transactional
	public List<PolicyHolder> getPolicyHolders() {
			
		return dao.getPolicyHolders();
	}

	@Override
	@Transactional
	public void save(PolicyHolder policyHolder) {
			dao.savePolicyHolder(policyHolder);
		
		
	}

	@Override
	@Transactional
	public PolicyHolder getHolderById(int PolicyId) {
		return dao.getPolicyHolderById(PolicyId);
	}

	@Override
	public PolicyHolder updateHolder(int policyId, PolicyHolder policyHolder) {
		
		return dao.updateHolder(policyId, policyHolder);
	}

}
