package com.springboot.repository;

import com.springboot.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository  extends JpaRepository<City,Integer> {
}
