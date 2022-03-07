package com.bhavna.HibernateCurd.Dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhavna.HibernateCurd.Entity.PolicyHolder;

@Repository
public class PolicyHolderDao {
	
	@Autowired
	public SessionFactory factory;
	
	 public List < PolicyHolder > getPolicyHolders() {
	        Session session = factory.openSession();
	        CriteriaBuilder cb = session.getCriteriaBuilder();
	        CriteriaQuery < PolicyHolder > cq = cb.createQuery(PolicyHolder.class);
	        Root < PolicyHolder > root = cq.from(PolicyHolder.class);
	        cq.select(root);
	        Query query = session.createQuery(cq);
	        return query.getResultList();
	    }
	 public void  savePolicyHolder(PolicyHolder theHolder) {
		 Session session = factory.openSession();
		 session.beginTransaction();
		 session.save(theHolder);
		 session.getTransaction().commit();
		 session.close();
		 
	 }
	 
	 public PolicyHolder getPolicyHolderById(int PolicyId) {
		 Session curreSession = factory.openSession();
		 PolicyHolder theHolder =curreSession.get(PolicyHolder.class, PolicyId);
		 curreSession.close();
		 return theHolder;
		 
	 }
	 
	 public PolicyHolder updateHolder(int policyId, PolicyHolder policyHolder) {
		 Session session = factory.openSession();
		 PolicyHolder theHolder = session.get(PolicyHolder.class, policyId);
		 session.close();
		return theHolder;
		 
	 }

}
