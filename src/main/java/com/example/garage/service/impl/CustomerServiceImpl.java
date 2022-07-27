package com.example.garage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.garage.entity.Customer;
import com.example.garage.repository.CustomerRepository;
import com.example.garage.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	
	public void insertCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	public Optional<Customer> findByID(Long id){
		return customerRepository.findById(id);
	}
	
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
	
	public boolean updateCustomer(Customer customer) {
		Optional<Customer> originalCustomer = customerRepository.findById(customer.getCusID());
		if(originalCustomer.isPresent()) {
			customerRepository.save(customer);
			return true;
		}
		return false;
	}
}
