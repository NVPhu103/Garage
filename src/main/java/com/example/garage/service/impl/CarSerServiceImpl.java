package com.example.garage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.garage.entity.CarService;
import com.example.garage.repository.CarServiceRepository;
import com.example.garage.service.CarSerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarSerServiceImpl implements CarSerService {

	private final CarServiceRepository carSerRepository;

	@Override
	public CarService addService(CarService service) {
		return carSerRepository.save(service);
	}

	@Override
	public List<CarService> findAllService() {
		return carSerRepository.findAll();
	}

	@Override
	public CarService findServiceById(Long id) {
		Optional<CarService> carService = carSerRepository.findById(id);
		if(carService.isEmpty()) {
			//TODO throws not found exception
		}
		return carService.get();
	}

	@Override
	public void deleteService(Long id) {
		// TODO Auto-generated method stub
		carSerRepository.deleteById(id);
	}

	@Override
	public CarService updateService(Long id, CarService service) {
		Optional<CarService> optionalCarServiceDB = carSerRepository.findById(id);
		if(optionalCarServiceDB.isEmpty()) {
			//TODO throw not found exception
		}
		CarService carServiceDB = optionalCarServiceDB.get();
		if(service.getSerDescription() != null && !service.getSerDescription().trim().equals("")) {
			carServiceDB.setSerDescription( service.getSerDescription() );
		}
		if(service.getSerName() != null && !service.getSerName().trim().equals("")) {
			carServiceDB.setSerName( service.getSerName() );
		}
		if(service.getSerPrice() < 0) {
			//TODO throw price exception
		}else {
			carServiceDB.setSerPrice( service.getSerPrice() );
		}
		return carSerRepository.save(carServiceDB);
	}

	
	

}
