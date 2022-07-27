package com.example.garage.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.garage.entity.CarService;
import com.example.garage.entity.RepairedCar;
import com.example.garage.entity.RepairedCarSer;
import com.example.garage.entity.RepairedCarSer.CompositePK;
import com.example.garage.repository.CarServiceRepository;
import com.example.garage.repository.RepairedCarRepository;
import com.example.garage.repository.RepairedCarSerRepository;
import com.example.garage.service.RepairedCarService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RepairedCarServiceImpl implements RepairedCarService{
	private final RepairedCarRepository repairedCarRepository;
	private final CarServiceRepository carServiceRepository;
	private final RepairedCarSerRepository repairedCarSerRepository;
	
	@Override
	public RepairedCar addRepairedCar(RepairedCar repairedCar) {
		return repairedCarRepository.save(repairedCar);
	}

	@Override
	public List<RepairedCar> findAllRepairedCar() {
		return repairedCarRepository.findAll();
	}

	@Override
	public RepairedCar findRepairedCarById(Long id) {
		Optional<RepairedCar> repairedCar = repairedCarRepository.findById(id);
		if(repairedCar.isEmpty()) {
			//TODO throws new Exception
		}
		return repairedCar.get();
	}

	@Override
	public void deleteRepairedCarById(Long id) {
		// TODO Auto-generated method stub
		repairedCarRepository.deleteById(id);;
	}

	@Override
	public RepairedCar updateRepairedCar(Long id, RepairedCar repairedCar) {
		Optional<RepairedCar> optionalCarDB = repairedCarRepository.findById(id);
		if(optionalCarDB.isEmpty()) {
			//TODO throw new Exception
		}
		RepairedCar carDB = optionalCarDB.get();
		if(repairedCar.getReCarDescription() != null && !repairedCar.getReCarDescription().trim().equals(""))
			carDB.setReCarDescription( repairedCar.getReCarDescription() );
		if(repairedCar.getReCarStartingDate() != null )
			carDB.setReCarStartingDate( repairedCar.getReCarStartingDate() );
		if(repairedCar.getReCarEndingDate() != null) {
			if(repairedCar.getReCarEndingDate().compareTo( carDB.getReCarStartingDate() ) <0 ) {
				//TODO throw new Exception Date
			}
			carDB.setReCarEndingDate( repairedCar.getReCarEndingDate() );
		}
		if(repairedCar.getReCarNumber() != null && !repairedCar.getReCarNumber().trim().equals(""))
			carDB.setReCarNumber(repairedCar.getReCarNumber());
		if(repairedCar.getReCarStatus() != null && !repairedCar.getReCarStatus().trim().equals(""))
			carDB.setReCarStatus( repairedCar.getReCarStatus() );
		if(repairedCar.getReCarType() != null && !repairedCar.getReCarType().trim().equals(""))
			carDB.setReCarType(repairedCar.getReCarType());
		return repairedCarRepository.save(carDB);
		
	}

	@Override
	public void addServiceToCar(Long repairedCarId, Long carServiceId) {
		Optional<RepairedCar> optionalRepairedCar = repairedCarRepository.findById(repairedCarId);
		Optional<CarService> optionalCarService = carServiceRepository.findById(carServiceId);
		if(optionalRepairedCar.isEmpty()) {
			System.out.println("car not found");
			//TODO throw exception car not found;
			return;
		}
		if(optionalCarService.isEmpty()) {
			System.out.println("service not found");
			//TODO throw exception car not found;
			return;
		}
	 	
		Optional<RepairedCarSer> service = repairedCarSerRepository.findById( new CompositePK(repairedCarId, carServiceId) );
		if(service.isPresent()) {
			//TODO throw ServiceAlreadyUsed Exception
			System.out.println("service already used");
			return;
		}
		RepairedCarSer repairedCarSer = new RepairedCarSer(new CompositePK(repairedCarId, carServiceId), optionalCarService.get().getSerPrice());
		repairedCarSerRepository.save(repairedCarSer);
	}

}
