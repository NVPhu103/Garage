package com.example.garage.service.impl;

import com.example.garage.entity.Goods;
import com.example.garage.repository.GoodsRepository;
import com.example.garage.service.GoodsService;
import com.example.garage.util.GoodsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }

    public Optional<Goods> findById(long id) {
        return goodsRepository.findById(id);
    }

    public boolean insertGoods(Goods goods) {
        if (GoodsValidator.isValid(goods)) {
            goodsRepository.save(goods);
            return true;
        }
        else {
            System.out.println("Goods not valid");
        }
        return false;
    }

    public boolean updateGoods(long id, Goods goods) {
        Optional<Goods> optionalGoods = findById(id);
        if (GoodsValidator.isValid(goods)) {
            if (optionalGoods.isPresent()) {
                Goods goodsFromDB = optionalGoods.get();
                goodsFromDB.setGoodsName(goods.getGoodsName());
                goodsFromDB.setGoodsPrice(goods.getGoodsPrice());
                goodsFromDB.setGoodsTotalQuantity(goods.getGoodsTotalQuantity());
//            goodsFromDB.setCategory(goods.getCategory());
                goodsFromDB.setListOfGoodsCar(goods.getListOfGoodsCar());
                goodsRepository.save(goodsFromDB);
                return true;
            }
            else {
                System.out.println("Goods not found");
            }
        }
        else {
            System.out.println("Goods not valid");
        }
        return false;
    }

    public void deleteGoods(long id) {
        goodsRepository.deleteById(id);
    }
}
