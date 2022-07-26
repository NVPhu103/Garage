package com.example.garage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.garage.entity.RepairedCar;

@Repository
public interface RepairedCarRepository extends JpaRepository<RepairedCar, Long> {

}
