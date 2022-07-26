package com.example.garage.service.impl;

import com.example.garage.entity.Goods;
import com.example.garage.repository.GoodsRepository;
import com.example.garage.service.GoodsService;
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

    public Optional<Goods> findById(int id) {
        return goodsRepository.findById(id);
    }

    public Goods insertGoods(Goods goods) {
        return goodsRepository.save(goods);
    }

    public boolean updateGoods(int id, Goods goods) {
        Optional<Goods> optionalGoods = findById(id);
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
        return false;
    }

    public void deleteGoods(int id) {
        goodsRepository.deleteById(id);
    }
}
