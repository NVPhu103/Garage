package com.example.garage.util;

import com.example.garage.entity.GoodsCar;

import java.util.Optional;

public class GoodsCarValidator {
    public static boolean isValid(GoodsCar goodsCar) {
        return Optional.ofNullable(goodsCar)
                .filter(g -> g.getGoodsCarPrice() > 0)
                .filter(g -> g.getGoodsCarQuantity() > 0)
                .filter(g -> g.getGoodsCarTotalPrice() > 0)
                .isPresent();
    }
}
