package com.dalaoyang.entity;

import javax.persistence.*;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.entity
 * @email yangyang@dalaoyang.cn
 * @date 2018/5/28
 */
@Entity
public class House {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(length = 10)
    private String houseName;
    private String houseSize;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(String houseSize) {
        this.houseSize = houseSize;
    }

    public House(String houseName, String houseSize) {
        this.houseName = houseName;
        this.houseSize = houseSize;
    }
}
