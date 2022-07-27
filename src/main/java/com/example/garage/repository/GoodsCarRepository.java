package com.example.garage.repository;

import com.example.garage.entity.GoodsCar;
import com.example.garage.entity.GoodsCarPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsCarRepository extends JpaRepository<GoodsCar, GoodsCarPK> {
}
