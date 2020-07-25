package com.springboot.controller;

import com.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //http://localhost:8080/createTable
    @GetMapping("createTable")
    public String createTable(){
        String sql =
                "CREATE TABLE `user` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `user_name` varchar(255) NOT NULL,\n" +
                "  `user_password` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;";
        jdbcTemplate.execute(sql);
        return "创建User表成功";
    }

    //http://localhost:8080/saveUserSql
    @GetMapping("saveUserSql")
    public String saveUserSql(){
        String sql = "INSERT INTO USER (USER_NAME,USER_PASSWORD) VALUES ('dalaoyang','123')";
        int rows= jdbcTemplate.update(sql);
        return "执行成功，影响"+rows+"行";
    }

    //http://localhost:8080/saveUser?userName=lisi&passWord=111
    @GetMapping("saveUser")
    public String saveUser(String userName,String passWord){
        int rows= jdbcTemplate.update("INSERT INTO USER (USER_NAME,USER_PASSWORD) VALUES (?,?)",userName,passWord);
        return "执行成功，影响"+rows+"行";
    }

    //http://localhost:8080/updateUserPassword?id=1&passWord=111
    @GetMapping("updateUserPassword")
    public String updateUserPassword(int id,String passWord){
        int rows= jdbcTemplate.update("UPDATE USER SET USER_PASSWORD = ? WHERE ID = ?",passWord,id);
        return "执行成功，影响"+rows+"行";
    }

    //http://localhost:8080/deleteUserById?id=1
    @GetMapping("deleteUserById")
    public String deleteUserById(int id){
        int rows= jdbcTemplate.update("DELETE FROM  USER  WHERE ID = ?",id);
        return "执行成功，影响"+rows+"行";
    }


    //http://localhost:8080/batchSaveUserSql
    @GetMapping("batchSaveUserSql")
    public String batchSaveUserSql(){
        String sql =
                "INSERT INTO USER (USER_NAME,USER_PASSWORD) VALUES (?,?)" ;
        List<Object[]> paramList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String[] arr = new String[2];
            arr[0] = "zhangsan"+i;
            arr[1] = "password"+i;
            paramList.add(arr);
        }
        jdbcTemplate.batchUpdate(sql,paramList);
        return "执行成功";
    }

    //http://localhost:8080/getUserByUserName?userName=zhangsan0
    @GetMapping("getUserByUserName")
    public List getUserByUserName(String userName){
        String sql = "SELECT * FROM USER WHERE USER_NAME = ?";
        List<User> list= jdbcTemplate.query(sql,new Object[]{userName},new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    //http://localhost:8080/getMapById?id=1
    @GetMapping("getMapById")
    public Map getMapById(Integer id){
        String sql = "SELECT * FROM USER WHERE ID = ?";
        Map map = null;
        try{
            map= jdbcTemplate.queryForMap(sql,id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return map;
    }

    //http://localhost:8080/getUserById?id=1
    @GetMapping("getUserById")
    public User getUserById(Integer id){
        String sql = "SELECT * FROM USER WHERE ID = ?";
        User user= null;
        try{
            user = jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(User.class));
        }catch (EmptyResultDataAccessException e){
            return null;
        }
        return user;
    }
}
