package cn.liuawen.controller;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-06
 */
@SpringBootTest(classes = SimpleController.class)
//定义要测试的SpringBoot类
@RunWith(SpringJUnit4ClassRunner.class)
//使用Junit进行测试
@WebAppConfiguration
//进行Web应用配置
//要加上public 不然测试方法执行不了
public class SimpleControllerTest {
    @Autowired
    //注入控制器对象
    private SimpleController simpleController;

    @Test
    public void testHome(){
        TestCase.assertEquals(this.simpleController.home(), "www.liuawen.cn");
        System.out.println("???");
    }
}