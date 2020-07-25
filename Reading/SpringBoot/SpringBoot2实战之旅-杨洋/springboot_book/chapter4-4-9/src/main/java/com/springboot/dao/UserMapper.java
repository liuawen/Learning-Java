package com.springboot.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> getUserList();

}