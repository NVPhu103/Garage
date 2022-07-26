package com.example.garage.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Goods_Car")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GoodsCar {
    @EmbeddedId
    private GoodsCarPK goodsCarPK;

    @Column(name = "Goodscar_quantity", nullable = false)
    private int goodsCarQuantity;

    @Column(name = "Goodscar_totalprice", nullable = false)
    private double goodsCarTotalPrice;

    @Column(name = "Goodscar_price", nullable = false)
    private double goodsCarPrice;

    public GoodsCar(int goodsCarQuantity, double goodsCarTotalPrice, double goodsCarPrice) {
        this.goodsCarQuantity = goodsCarQuantity;
        this.goodsCarTotalPrice = goodsCarTotalPrice;
        this.goodsCarPrice = goodsCarPrice;
    }
}
