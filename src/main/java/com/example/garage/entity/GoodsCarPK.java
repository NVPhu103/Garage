package com.example.garage.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class GoodsCarPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Goods_number")
    private Goods goods;

    @ManyToOne
    @JoinColumn(name = "Car_id")
    private RepairedCar car;

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = (int) (result * prime + goods.getGoodsNumber());
        result = (int) (result * prime + car.getReCarId());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this == null) {
            if (obj != null) {
                return false;
            }
            else {
                return true;
            }
        }
        GoodsCarPK goodsCarPK = (GoodsCarPK) obj;
        if (this.goods.getGoodsNumber() != goodsCarPK.getGoods().getGoodsNumber()) {
            return false;
        }
        if (this.car.getReCarId() != goodsCarPK.getCar().getReCarId()) {
            return false;
        }
        return true;
    }
}
