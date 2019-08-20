package com.imooc.jdbc.service;

import com.imooc.jdbc.bean.User;
import com.imooc.jdbc.dao.UserDAO;

/**
 * UserService
 *
 * @version 1.0
 */
public class UserService {

    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 成功返回用户Bean，失败返回null
     */
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

}
