package com.springboot.controller;


import com.springboot.entity.datasource.City;
import com.springboot.entity.datasource2.House;
import com.springboot.mapper.datasource.CityMapper;
import com.springboot.mapper.datasource2.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    HouseMapper houseMapper;

    @Autowired
    CityMapper cityMapper;


    @GetMapping("/testDataSource")
    public Map testDataSource(){
        Map map = new HashMap();
        List<City> cityList=cityMapper.getAllCity();
        List<House> houseList=houseMapper.getAllHouse();
        map.put("cityList",cityList);
        map.put("houseList",houseList);
        return map;
    }



}
