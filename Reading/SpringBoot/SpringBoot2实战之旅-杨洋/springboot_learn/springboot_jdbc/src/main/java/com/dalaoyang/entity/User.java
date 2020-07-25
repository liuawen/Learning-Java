package com.dalaoyang.entity;


import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author dalaoyang
 * @project springboot_learn
 * @package com.dalaoyang.entity
 * @email yangyang@dalaoyang.cn
 * @date 2018/7/25
 */
public class User implements RowMapper<User> {
    private int id;
    private String user_name;
    private String pass_word;

    public User(int id, String user_name, String pass_word) {
        this.id = id;
        this.user_name = user_name;
        this.pass_word = pass_word;
    }

    public User() {
    }

    public User(String user_name, String pass_word) {
        this.user_name = user_name;
        this.pass_word = pass_word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUser_name(resultSet.getString("user_name"));
        user.setPass_word(resultSet.getString("pass_word"));
        return user;
    }
}
