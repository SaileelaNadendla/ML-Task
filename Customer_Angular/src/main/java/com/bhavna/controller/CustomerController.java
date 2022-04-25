package com.bhavna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.entity.Customer;
import com.bhavna.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
		
	}
	
	@CrossOrigin
	@PostMapping("/createCustomer")
	public Customer createCustomer(@RequestBody Customer cust) {
		return service.addCustomer(cust);
		
	}
	@CrossOrigin
	@GetMapping("/getAllCustomers/{customerId}")
	public Optional<Customer> getCustomerById(@PathVariable Integer customerId) {
		return service.getByCustomerId(customerId);

	}

	@CrossOrigin
	@PutMapping("/updateCustomer/{customerId}")
	public void updateCustomer(@RequestBody Customer customer, @PathVariable Integer customerId) {
	 service.updateCustomer(customer, customerId);
	}
	
	
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public void deleteCustomer(@PathVariable Integer customerId, Customer customer) {
		service.deleteCustomer(customerId);
	}

	

}
