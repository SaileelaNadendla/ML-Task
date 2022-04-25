package com.bhavna.service;

import java.util.List;
import java.util.Optional;

import com.bhavna.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	Customer addCustomer(Customer customer);
    void updateCustomer(Customer customer, Integer customerId);
	void deleteCustomer(Integer custmoreId);
	Optional<Customer> getByCustomerId(Integer customerId);

		
	

}
