package com.example.garage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.garage.entity.Bill;
import com.example.garage.entity.Customer;
import com.example.garage.repository.BillRepository;
import com.example.garage.service.BillService;

public class BillServiceImpl implements BillService {
	@Autowired
	private BillRepository billRepository;
	
	@Override
	public void insertCustomer(Bill bill) {
		billRepository.save(bill);
	}
	
	@Override
	public List<Bill> findAll(){
		return billRepository.findAll();
	}
	
	@Override
	public Optional<Bill> findByID(Long id){
		return billRepository.findById(id);
	}
	
	@Override
	public void deleteCustomer(Long id) {
		billRepository.deleteById(id);
	}
	
	@Override
	public boolean updateCustomer(Bill bill) {
		Optional<Bill> originalBill = billRepository.findById(bill.getBillNumber());
		if(originalBill.isPresent()) {
			billRepository.save(bill);
			return true;
		}
		return false;
	}
}
