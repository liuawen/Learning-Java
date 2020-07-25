package com.dalaoyang.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.dalaoyang.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.dao
 * @email yangyang@dalaoyang.cn
 * @date 2018/7/20
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> getUserList();

}
