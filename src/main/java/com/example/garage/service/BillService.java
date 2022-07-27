package com.example.garage.service;

import java.util.List;
import java.util.Optional;

import com.example.garage.entity.Bill;

public interface BillService {

	void insertCustomer(Bill bill);

	List<Bill> findAll();

	Optional<Bill> findByID(Long id);

	void deleteCustomer(Long id);

	boolean updateCustomer(Bill bill);

}