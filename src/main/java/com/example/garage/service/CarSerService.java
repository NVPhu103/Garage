package com.example.garage.service;

import java.util.List;

import com.example.garage.entity.CarService;

public interface CarSerService {
	public CarService addService(CarService service);
	public List<CarService> findAllService();
	public CarService findServiceById(Long id);
	public void deleteService(Long id);
	public CarService updateService(Long id, CarService service);
}
