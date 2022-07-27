package com.example.garage.util;

import com.example.garage.entity.Goods;

import java.util.Optional;

public class GoodsValidator {
    public static boolean isValid(Goods goods) {
        return Optional.ofNullable(goods)
                .filter(g -> g.getGoodsName() != null)
                .filter(g -> g.getGoodsPrice() > 0)
                .filter(g -> g.getGoodsTotalQuantity() > 0)
                .filter(g -> g.getListOfGoodsCar() != null)
                .isPresent();
    }
}
