package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.Dao.EmpDao;
import com.bhavna.entity.EMP;
@Service
public class EmpImpl implements EmpService{
	@Autowired
	private EmpDao empDao;

	@Override
	public List<EMP> getEmployees() {
		return empDao.getEmployees();
	}
	

}
