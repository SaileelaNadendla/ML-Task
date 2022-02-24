package com.bhavna.Dao;

import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bhavna.entity.EMP;
@Component
public class EmpDaoImpl implements EmpDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<EMP> getEmployees() {
		org.hibernate.Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<EMP> cq =cb.createQuery(EMP.class);
		Root<EMP> root =cq.from(EMP.class);
		cq.select(root);
		org.hibernate.query.Query<EMP> query =session.createQuery(cq);
		return query.getResultList();
	}
	
	

}
