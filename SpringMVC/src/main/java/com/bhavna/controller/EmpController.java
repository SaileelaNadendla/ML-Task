package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.model.Employee;
import com.bhavna.service.EmployeeService;

@RestController
public class EmpController {
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/getAllEmployees")
	public List<Employee> getActiveEmployee(){
		return employeeService.getAllActiveEmployees();
		
	}
	
	@RequestMapping("/welcome")
	public String get() {
		return "Welcome";
	}
	@RequestMapping("/get/{id}")
	public Employee getEmployeeById(@PathVariable Integer empId) {
		Employee emp = employeeService.getEmployeeById(empId);
		
		return emp;
		
	}

}
