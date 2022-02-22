package com.bhavna.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.bhavna.Repository.EmployeeRep;
import com.bhavna.model.Employee;

@Service
@Transactional
public class EmployeeImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRep employeeRep;
	
	public EmployeeImpl() {
		
	}
	
	
	@Override
	public List<Employee> getAllActiveEmployees() {
		List<Employee> list = new ArrayList();
		employeeRep.findAll().forEach(emp->list.add(emp));
		
		return list;
	}


	@Override
	public Employee getEmployeeById(Integer empId) {
		Employee emp = employeeRep.findById(empId).get();
				//Employee emp = employeeRep.findById(empId).get();


;
	
		return emp;
	}
	

}
