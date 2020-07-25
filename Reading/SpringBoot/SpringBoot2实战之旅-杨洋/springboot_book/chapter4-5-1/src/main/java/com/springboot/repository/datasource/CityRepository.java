package com.springboot.repository.datasource;

import com.springboot.entity.datasource.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
}
