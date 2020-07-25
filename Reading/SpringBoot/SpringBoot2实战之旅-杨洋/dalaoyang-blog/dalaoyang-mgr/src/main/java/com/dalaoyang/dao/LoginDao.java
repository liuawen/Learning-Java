package com.dalaoyang.dao;

import com.dalaoyang.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginDao {

    UserInfo findUserByUserNameAndPassword(Map map);

    List<UserInfo> getUserList();

}
