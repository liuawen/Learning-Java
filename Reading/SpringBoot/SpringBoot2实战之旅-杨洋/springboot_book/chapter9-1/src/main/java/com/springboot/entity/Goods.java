package com.springboot.entity;

import java.io.Serializable;

public class Goods implements Serializable {


    private static final long serialVersionUID = 6629065135155452917L;

    private Long goodsId;
    private String goodsName;
    private String goodsIntroduce;
    private Double goodsPrice;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Goods(Long goodsId, String goodsName, String goodsIntroduce, Double goodsPrice) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsIntroduce = goodsIntroduce;
        this.goodsPrice = goodsPrice;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsIntroduce='" + goodsIntroduce + '\'' +
                ", goodsPrice=" + goodsPrice +
                '}';
    }
}
