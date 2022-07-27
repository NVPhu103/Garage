package com.example.garage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.garage.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{

}
