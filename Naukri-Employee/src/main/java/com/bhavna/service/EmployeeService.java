package com.bhavna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.entity.Employee;
import com.bhavna.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	public Employee insertEmployee(Employee emp) {
		return repo.save(emp);
		
	}
	
	public List<Employee> getEmployees(){
		return repo.findAll();
		
	}
     

	public Optional<Employee> getEmployeeByName(String empName) {
     return repo.findById(empName);
	}
		
	}
	

