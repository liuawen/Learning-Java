package cn.liuawen.demo;

import cn.liuawen.service.UserService;
import cn.liuawen.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-08
 */
public class UserController {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.save();

//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = (UserService) app.getBean("userService");
//        userService.save();

/*        //Exception in thread "main" java.lang.NullPointerException
        UserService userService = new UserServiceImpl();
        userService.save();*/

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserServiceImpl)app.getBean("userService");
        userService.save();
    }
}
