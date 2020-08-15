package com.itheima_07;

/*
    学生类

    构造方法：
        作用：创建对象
        功能：完成对象数据的初始化

    格式：
        修饰符 类名(参数) {

        }

        修饰符一般用：public
 */
public class Student {
    private String name;
    private int age;

    //构造方法
    public Student() {
        System.out.println("无参构造方法");
    }

    public void show() {
        System.out.println(name + "," + age);
    }
}
