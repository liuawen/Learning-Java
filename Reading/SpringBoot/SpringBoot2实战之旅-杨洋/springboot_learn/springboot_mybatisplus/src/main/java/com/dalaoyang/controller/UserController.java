package com.dalaoyang.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.dalaoyang.dao.UserMapper;
import com.dalaoyang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/7/20
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userDao;

    //http://localhost:8888/getUserList
    @GetMapping("getUserList")
    public List<User> getUserList(){
        return userDao.getUserList();
    }

    //http://localhost:8888/getUserListByName?userName=xiaoli
    //条件查询
    @GetMapping("getUserListByName")
    public List<User> getUserListByName(String userName)
    {
        Map map = new HashMap();
        map.put("user_name", userName);
        return userDao.selectByMap(map);
    }

    //http://localhost:8888/saveUser?userName=xiaoli&userPassword=111
    //保存用户
    @GetMapping("saveUser")
    public String saveUser(String userName,String userPassword)
    {
        User user = new User(userName,userPassword);
        Integer index = userDao.insert(user);
        if(index>0){
            return "新增用户成功。";
        }else{
            return "新增用户失败。";
        }
    }

    //http://localhost:8888/updateUser?id=5&userName=xiaoli&userPassword=111
    //修改用户
    @GetMapping("updateUser")
    public String updateUser(Integer id,String userName,String userPassword)
    {
        User user = new User(id,userName,userPassword);
        Integer index = userDao.updateById(user);
        if(index>0){
            return "修改用户成功，影响行数"+index+"行。";
        }else{
            return "修改用户失败，影响行数"+index+"行。";
        }
    }


    //http://localhost:8888/getUserById?userId=1
    //根据Id查询User
    @GetMapping("getUserById")
    public User getUserById(Integer userId)
    {
        return userDao.selectById(userId);
    }

    //http://localhost:8888/getUserListByPage?pageNumber=1&pageSize=2
    //条件分页查询
    @GetMapping("getUserListByPage")
    public List<User> getUserListByPage(Integer pageNumber,Integer pageSize)
    {
        Page<User> page =new Page<>(pageNumber,pageSize);
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name", "xiaoli");
        return userDao.selectPage(page,entityWrapper);
    }

}
