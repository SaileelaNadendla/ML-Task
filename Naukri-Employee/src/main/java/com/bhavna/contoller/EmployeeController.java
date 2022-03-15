package com.bhavna.contoller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.entity.Employee;
import com.bhavna.service.EmployeeService;

@RestController
@RefreshScope
public class EmployeeController {
	
	@Value("${domain}")
	public String message;
	
	@GetMapping("/message")
	public String getmessage() {
		return message;
		
	}
			
	@Autowired
	public EmployeeService service;
	
	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return service.getEmployees();
		
	}
	
	
	@GetMapping("/getEmployee/{empName}" + "${domain}")
	public Optional<Employee> getEmployeeByName(@PathVariable("empName") String empName) {
	return service.getEmployeeByName(empName);
	}

	
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		service.insertEmployee(employee);
		return "Employee added Successfully....";

	}
	



}
