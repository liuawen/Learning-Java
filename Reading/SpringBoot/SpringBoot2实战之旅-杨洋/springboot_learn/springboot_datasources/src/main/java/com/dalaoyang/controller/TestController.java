package com.dalaoyang.controller;

import com.dalaoyang.entity.datasource.City;
import com.dalaoyang.entity.datasource2.House;
import com.dalaoyang.repository.datasource.CityRepository;
import com.dalaoyang.repository.datasource2.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/10
 */
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
        return "success";
    }

    @GetMapping("/testDataSource2")
    public String testDataSource2(){
        House house = new House("豪宅","特别大的豪宅");
        houseRepository.save(house);
        return "success";
    }

}
