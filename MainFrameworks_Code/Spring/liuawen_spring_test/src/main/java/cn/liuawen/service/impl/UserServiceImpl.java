package cn.liuawen.service.impl;

import cn.liuawen.dao.RoleDao;
import cn.liuawen.dao.UserDao;
import cn.liuawen.domain.Role;
import cn.liuawen.domain.User;
import cn.liuawen.service.UserService;

import java.util.List;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-14
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;
   private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> list() {
        //Role roles
        List<User> userList = userDao.findAll();
        //封装userList中的每一个User的roles数据
        for (User user:userList){
            //获取用户的id
            long id = user.getId();
            //讲id作为参数 查询当前的userId对应的Role集合数据
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }
}
