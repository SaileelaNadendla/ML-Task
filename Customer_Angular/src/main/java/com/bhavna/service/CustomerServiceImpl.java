package com.bhavna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.Repository.CustomerRepository;
import com.bhavna.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository repo;

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		return repo.save(customer);
	}


	@Override
	public void updateCustomer(Customer customer, Integer customerId) {
     		repo.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
      repo.deleteById(customerId);		
	}

	@Override
	public Optional<Customer> getByCustomerId(Integer customerId) {
		
		return repo.findById(customerId);
	}

	
}
