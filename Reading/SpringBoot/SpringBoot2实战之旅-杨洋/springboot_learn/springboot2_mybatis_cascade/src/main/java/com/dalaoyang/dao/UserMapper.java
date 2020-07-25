package com.dalaoyang.dao;

import com.dalaoyang.entity.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    User findUserByUsername(String username);

}
