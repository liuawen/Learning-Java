package com.springboot.controller;

import com.springboot.entity.City;
import com.springboot.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping(value = "saveCity")
    public String saveCity(String cityName,String cityIntroduce){
        City city = new City(cityName,cityIntroduce);
        cityRepository.save(city);
        return "success";
    }

    @GetMapping(value = "deleteCity")
    public String deleteCity(int cityId){
        cityRepository.deleteById(cityId);
        return "success";
    }

    @GetMapping(value = "updateCity")
    public String updateCity(int cityId,String cityName,String cityIntroduce){
        City city = new City(cityId,cityName,cityIntroduce);
        cityRepository.save(city);
        return "success";
    }

    @GetMapping(value = "getCityById")
    public City getCityById(Integer cityId){
        Optional<City> optionalCity = cityRepository.findById(cityId);
        return optionalCity.isPresent()?optionalCity.get():null;
    }

    @GetMapping(value = "getCityById")
    public City getCityById(Integer cityId, HttpServletRequest request){
        Optional<City> optionalCity = cityRepository.findById(cityId);
        HttpSession session = request.getSession();
        City city = optionalCity.isPresent() ? optionalCity.get() : null;
        session.setAttribute(cityId.toString(),city);
        return city;
    }

}

