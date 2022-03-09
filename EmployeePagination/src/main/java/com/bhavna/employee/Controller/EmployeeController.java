package com.bhavna.employee.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.employee.Service.EmployeeService;
import com.bhavna.employee.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size) {

		return service.getAllEmployees(page, size);

	}

	@GetMapping("/getAllEmployees/{id}")
	public Optional<Employee> getById(@PathVariable Integer id) {
		return service.getByEmployeeId(id);

	}

	@PutMapping("/update/{id}")
	public String updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
		return service.updateEmployee(employee, id);

	}

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		service.addEmployee(employee);
		return "Employee added Successfully....";

	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		service.deleteEmployeeById(id);
		return "Employee deleted successfully...";

	}

}
