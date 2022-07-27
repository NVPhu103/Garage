package com.example.garage.service;

import java.util.List;
import java.util.Optional;

import com.example.garage.entity.Customer;

public interface CustomerService {
	
	void insertCustomer(Customer customer);
	
	List<Customer> findAll();
	
	Optional<Customer> findByID(Long id);
	
	void deleteCustomer(Long id);
	
	boolean updateCustomer(Customer customer);
}
