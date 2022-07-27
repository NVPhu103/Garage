package com.example.garage.service;

import com.example.garage.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface GoodsService {
    public List<Goods> findAll();
    public Optional<Goods> findById(long id);
    public boolean insertGoods(Goods goods);
    public boolean updateGoods(long id, Goods goods);
    public void deleteGoods(long id);
}
