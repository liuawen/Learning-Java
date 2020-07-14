package com.imooc.springboot.ioc;

import lombok.AllArgsConstructor;

/**
 * @Author : 刘水镜
 * @Description :
 * @Date Create in 2019/12/30 21:53
 */
@AllArgsConstructor
public class Person {

    private Driveable driveable;

    public void hangOut() {
        driveable.drive();
    }
}
