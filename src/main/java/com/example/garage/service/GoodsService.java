package com.example.garage.service;

import com.example.garage.entity.Goods;

import java.util.List;
import java.util.Optional;

public interface GoodsService {
    public List<Goods> findAll();
    public Optional<Goods> findById(int id);
    public Goods insertGoods(Goods goods);
    public boolean updateGoods(int id, Goods goods);
    public void deleteGoods(int id);
}
