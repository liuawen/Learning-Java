package com.springboot.mapper.datasource2;

import com.springboot.entity.datasource2.House;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HouseMapper {

    @Select("SELECT * FROM House")
    @Results({
            @Result(property = "houseId",  column = "house_id"),
            @Result(property = "houseName", column = "house_name"),
            @Result(property = "houseIntroduce", column = "house_introduce")
    })
    List<House> getAllHouse();
}
