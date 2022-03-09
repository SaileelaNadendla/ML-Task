package com.bhavna.employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bhavna.employee.Repository.EmployeeRepository;
import com.bhavna.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public List<Employee> getAllEmployees(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Employee> pagedResult = repo.findAll(pageable);
		return pagedResult.toList();
	}

	@Override
	public Optional<Employee> getByEmployeeId(Integer id) {
		return repo.findById(id);

	}

	@Override
	public Employee addEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public String updateEmployee(Employee employee, Integer id) {
		if (repo.existsById(id)) {
			repo.save(employee);
			return "Employee details updated...!";

		} else {
			return "Data not Found....!";
		}

	}

	@Override
	public void deleteEmployeeById(Integer id) {
		repo.deleteById(id);

	}


}
