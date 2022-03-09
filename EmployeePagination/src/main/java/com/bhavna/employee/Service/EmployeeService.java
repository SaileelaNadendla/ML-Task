package com.bhavna.employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.bhavna.employee.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees(int pageNo, int pageSize);

	public Optional<Employee> getByEmployeeId(Integer id);

	Employee addEmployee(Employee employee);

	String updateEmployee(Employee employee, Integer id);

	void deleteEmployeeById(Integer id);
}