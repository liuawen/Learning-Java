package com.imooc.springboot.ioc;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : 刘水镜
 * @Description :
 * @Date Create in 2019/12/30 21:57
 */
//@RunWith(JUnit4.class)
public class IocTests {

    // Bean 容器
    private Map<String, Object> container = new HashMap<>();

    /**
     * 模拟 Spring 容器初始化
     */
    @Before
    public void init() {
        Driveable bike = new Bike();
        container.put("bike", bike);

        Driveable car = new Car();
        container.put("car", car);

        Driveable train = new Train();
        container.put("train", train);

        Driveable airPlane = new AirPlane();
        container.put("airPlane", airPlane);

        Driveable ship = new Ship();
        container.put("ship", ship);
    }

    /**
     * 获取 Bean
     * @param name
     * @return
     */
    public Object getBean(String name) {
        return container.get(name);
    }

    @Test
    public void test() {
        Driveable bike = (Driveable) container.get("bike");
        Person xiaoming = new Person(bike);
        xiaoming.hangOut();

        Driveable car = (Driveable) container.get("car");
        xiaoming = new Person(car);
        xiaoming.hangOut();

        Driveable train = (Driveable) container.get("train");
        xiaoming = new Person(train);
        xiaoming.hangOut();

        Driveable airPlane = (Driveable) container.get("airPlane");
        xiaoming = new Person(airPlane);
        xiaoming.hangOut();

        Driveable ship = (Driveable) container.get("ship");
        xiaoming = new Person(ship);
        xiaoming.hangOut();
    }
}
