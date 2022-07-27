package com.example.garage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.garage.entity.RepairedCarSer;

@Repository
public interface RepairedCarSerRepository extends JpaRepository<RepairedCarSer, RepairedCarSer.CompositePK> {

}
