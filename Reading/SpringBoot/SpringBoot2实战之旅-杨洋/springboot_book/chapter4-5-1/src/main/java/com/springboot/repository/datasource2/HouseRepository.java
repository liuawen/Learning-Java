package com.springboot.repository.datasource2;

import com.springboot.entity.datasource2.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House,Integer> {
}
