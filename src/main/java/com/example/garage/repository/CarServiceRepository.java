package com.example.garage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.garage.entity.CarService;

@Repository
public interface CarServiceRepository extends JpaRepository<CarService, Long> {
	
}
