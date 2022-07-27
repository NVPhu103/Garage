package com.example.garage.service;

import com.example.garage.entity.GoodsCar;
import com.example.garage.entity.GoodsCarPK;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GoodsCarService {
    List<GoodsCar> findAll();
    Optional<GoodsCar> findById(GoodsCarPK goodsCarPK);
    boolean insertGoodsCar(GoodsCar goodsCar);
    boolean updateGoodsCar(GoodsCarPK goodsCarPK, GoodsCar goodsCar);
    void deleteGoodsCar(GoodsCarPK goodsCarPK);
}
