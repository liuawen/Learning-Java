package com.springboot.entity;
//实体类Goods
public class Goods {
    private Long id;
    private String goodsName;
    private String goodsIntroduce;
    private Double goodsPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Goods(Long id, String goodsName, String goodsIntroduce, Double goodsPrice) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsIntroduce = goodsIntroduce;
        this.goodsPrice = goodsPrice;
    }

    public Goods(String goodsName, String goodsIntroduce, Double goodsPrice) {
        this.goodsName = goodsName;
        this.goodsIntroduce = goodsIntroduce;
        this.goodsPrice = goodsPrice;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsIntroduce='" + goodsIntroduce + '\'' +
                ", goodsPrice=" + goodsPrice +
                '}';
    }
}
