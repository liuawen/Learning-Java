package com.springboot.controller;


import com.springboot.entity.datasource.City;
import com.springboot.entity.datasource2.House;
import com.springboot.repository.datasource.CityRepository;
import com.springboot.repository.datasource2.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    HouseRepository houseRepository;

    @GetMapping("/testDataSource")
    public String testDataSource(){
        City city = new City("北京","中国首都");
        cityRepository.save(city);
        House house = new House("豪宅","特别大的豪宅");
        houseRepository.save(house);
        return "success";
    }


}
