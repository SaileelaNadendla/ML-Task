package com.bhavna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bhavna.model.Employee;

@Service
public interface EmployeeService {
	public List<Employee> getAllActiveEmployees();

	public Employee getEmployeeById(Integer empId);

}
