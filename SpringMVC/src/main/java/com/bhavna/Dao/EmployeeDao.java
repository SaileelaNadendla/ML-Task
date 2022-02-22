package com.bhavna.Dao;

import java.util.List;

import com.bhavna.model.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployee();
	List<Employee> getAllActiveEmployee();

}
