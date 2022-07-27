package com.example.garage.service.impl;

import com.example.garage.entity.GoodsCar;
import com.example.garage.entity.GoodsCarPK;
import com.example.garage.repository.GoodsCarRepository;
import com.example.garage.service.GoodsCarService;
import com.example.garage.util.GoodsCarValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodsCarServiceImpl implements GoodsCarService {
    @Autowired
    private GoodsCarRepository goodsCarRepository;

    @Override
    public List<GoodsCar> findAll() {
        return goodsCarRepository.findAll();
    }

    @Override
    public Optional<GoodsCar> findById(GoodsCarPK goodsCarPK) {
        return goodsCarRepository.findById(goodsCarPK);
    }

    @Override
    public boolean insertGoodsCar(GoodsCar goodsCar) {
        if (GoodsCarValidator.isValid(goodsCar)) {
            goodsCarRepository.save(goodsCar);
            return true;
        }
        else {
            System.out.println("Goods Car not valid");
        }
        return false;
    }

    @Override
    public boolean updateGoodsCar(GoodsCarPK goodsCarPK, GoodsCar goodsCar) {
        Optional<GoodsCar> optionalGoodsCar = goodsCarRepository.findById(goodsCarPK);
        if (GoodsCarValidator.isValid(goodsCar)) {
            if (optionalGoodsCar.isPresent()) {
                GoodsCar goodsCarFromDB = optionalGoodsCar.get();
                goodsCarFromDB.setGoodsCarPrice(goodsCar.getGoodsCarPrice());
                goodsCarFromDB.setGoodsCarQuantity(goodsCar.getGoodsCarQuantity());
                goodsCarFromDB.setGoodsCarTotalPrice(goodsCar.getGoodsCarTotalPrice());
                goodsCarRepository.save(goodsCarFromDB);
                return true;
            }
            else {
                System.out.println("Goods Car not found");
            }
        }
        else {
            System.out.println("Goods Car not valid");
        }
        return false;
    }

    @Override
    public void deleteGoodsCar(GoodsCarPK goodsCarPK) {
        goodsCarRepository.deleteById(goodsCarPK);
    }
}
