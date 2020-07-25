package com.dalaoyang.dao;

import com.dalaoyang.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.dao
 * @email 397600342@qq.com
 * @date 2018/4/5
 */
@Mapper
public interface UserMapper {
    User findUserByUsername(String username);

    void updateUserByUsername(User user);

    void deleteUserByUsername(String username);

    void saveUser(User user);

    List<User> getUserList();
}
