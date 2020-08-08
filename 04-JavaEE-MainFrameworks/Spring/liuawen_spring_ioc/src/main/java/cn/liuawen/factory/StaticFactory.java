package cn.liuawen.factory;

import cn.liuawen.dao.UserDao;
import cn.liuawen.dao.impl.UserDaoImpl;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-07
 *  工厂静态方法实例化
 *
 */
public class StaticFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
