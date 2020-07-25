package com.springboot.entity.datasource2;


public class House {
    private int houseId;
    private String houseName;
    private String houseIntroduce;

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseIntroduce() {
        return houseIntroduce;
    }

    public void setHouseIntroduce(String houseIntroduce) {
        this.houseIntroduce = houseIntroduce;
    }


    public House(int houseId, String houseName, String houseIntroduce) {
        this.houseId = houseId;
        this.houseName = houseName;
        this.houseIntroduce = houseIntroduce;
    }
}
