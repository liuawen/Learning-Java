package com.dalaoyang.controller;

import com.dalaoyang.entity.City;
import com.dalaoyang.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email 397600342@qq.com
 * @date 2018/4/7
 */
@RestController
public class CityController {


    @Autowired
    private CityRepository cityRepository;


    //http://localhost:8888/saveCity?cityName=北京&cityIntroduce=中国首都
    @GetMapping(value = "saveCity")
    public String saveCity(String cityName,String cityIntroduce){
        City city = new City(cityName,cityIntroduce);
        cityRepository.save(city);
        return "success";
    }

    //http://localhost:8888/deleteCity?cityId=2
    @GetMapping(value = "deleteCity")
    public String deleteCity(int cityId){
        cityRepository.delete(cityId);
        return "success";
    }

    //http://localhost:8888/updateCity?cityId=3&cityName=沈阳&cityIntroduce=辽宁省省会
    @GetMapping(value = "updateCity")
    public String updateCity(int cityId,String cityName,String cityIntroduce){
        City city = new City(cityId,cityName,cityIntroduce);
        cityRepository.save(city);
        return "success";
    }


    //http://localhost:8888/getCityById?cityId=3
    @GetMapping(value = "getCityById")
    public City getCityById(Integer cityId,HttpServletRequest request){
        City city = cityRepository.findOne(cityId);
        HttpSession session = request.getSession();
        session.setAttribute(cityId.toString(),city);
        return city;
    }
}
