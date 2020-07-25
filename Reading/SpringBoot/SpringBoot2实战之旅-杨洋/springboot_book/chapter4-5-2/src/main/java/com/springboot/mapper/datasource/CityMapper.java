package com.springboot.mapper.datasource;

import com.springboot.entity.datasource.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityMapper {

    @Select("SELECT * FROM City")
    @Results({
            @Result(property = "cityId",  column = "city_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "cityIntroduce", column = "city_introduce")
    })
    List<City> getAllCity();
}
