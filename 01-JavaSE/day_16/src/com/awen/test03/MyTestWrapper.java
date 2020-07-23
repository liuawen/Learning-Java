package com.awen.test03;

import org.junit.Test;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-20
 */
public class MyTestWrapper {
    @Test
    public void test01(){
        //装箱操作   手动
        int a = 1;
        Integer aObj = new Integer(a);

        System.out.println(a);// 1
        System.out.println(aObj);// 1

        System.out.println(aObj.getClass());// class java.lang.Integer
        System.out.println(aObj.hashCode());// 1
    }
}
