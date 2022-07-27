package com.example.garage.service;


import java.util.List;

import com.example.garage.entity.RepairedCar;


public interface RepairedCarService {
	public RepairedCar addRepairedCar(RepairedCar repairedCar );
	public List<RepairedCar> findAllRepairedCar();
	public RepairedCar findRepairedCarById(Long id);
	public void deleteRepairedCarById(Long id);
	public RepairedCar updateRepairedCar(Long id, RepairedCar repairedCar);
	public void addServiceToCar(Long repairedCarId, Long carServiceId);
}
