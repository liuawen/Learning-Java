package com.dalaoyang.controller;

import com.dalaoyang.entity.House;
import com.dalaoyang.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/5/28
 */
@RestController
public class HouseController {

    @Autowired
    private HouseRepository houseRepository;

    @GetMapping("/test1")
    public String test1(){
        houseRepository.save(new House("house1", "100平方米"));
        houseRepository.save(new House("house2", "100平方米"));
        houseRepository.save(new House("house3", "100平方米"));
        houseRepository.save(new House("house444444444", "100平方米"));
        houseRepository.save(new House("house5", "100平方米"));
        return "success";
    }

    @GetMapping("/test2")
    @Transactional
    public String test2(){
        houseRepository.save(new House("house6", "100平方米"));
        houseRepository.save(new House("house7", "100平方米"));
        houseRepository.save(new House("house8", "100平方米"));
        houseRepository.save(new House("house999999999", "100平方米"));
        houseRepository.save(new House("house10", "100平方米"));
        return "success";
    }
}
