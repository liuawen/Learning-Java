package com.springboot.dao;

import com.springboot.entity.User;
import com.springboot.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    User findUserByUsername(String username);

    void updateUserByUsername(User user);

    void deleteUserByUsername(String username);

    void saveUser(User user);

    List<User> getUserList();

    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "user_name",column = "user_name"),
            @Result(property = "pass_word",column = "pass_word")
    })
    @Select("SELECT * FROM USER")
    List<User> findAll();

    @SelectProvider(type = UserSqlProvider.class,method = "getSql")
    List<User> findUserById(@Param("id") int id);

}
