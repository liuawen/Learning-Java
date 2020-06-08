package cn.liuawen.factory;

import cn.liuawen.dao.UserDao;
import cn.liuawen.dao.impl.UserDaoImpl;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-08
 */
public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
