package com.awen.test02.abstract_;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-18
 */
public class Person {
    private String name;
    private int age;

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1 == p2);//false
        p1 = p2;
        System.out.println(p1 == p2);//true

        Person p = new Person();
        String str = "hello";
//        System.out.println(p == str);//错误，p和String类型不兼容，Person和String类型无父子类关系
    }
}
