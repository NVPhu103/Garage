package com.example.garage.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Goods")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Goods_number")
    private long goodsNumber;

    @Column(name = "Goods_name", columnDefinition = "NVARCHAR(80)", nullable = false)
    private String goodsName;

    @Column(name = "Goods_price", nullable = false)
    private double goodsPrice;

    @Column(name = "Goods_totalquantity", nullable = false)
    private int goodsTotalQuantity;

//    @ManyToOne
//    @JoinColumn(name = "Cat_number")
//    private Category category;

    @OneToMany(mappedBy = "goodsCarPK.goods", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<GoodsCar> listOfGoodsCar;


//    public Goods(String goodsName, double goodsPrice, int goodsTotalQuantity, Category category) {
//        this.goodsName = goodsName;
//        this.goodsPrice = goodsPrice;
//        this.goodsTotalQuantity = goodsTotalQuantity;
//        this.category = category;
//    }
}
