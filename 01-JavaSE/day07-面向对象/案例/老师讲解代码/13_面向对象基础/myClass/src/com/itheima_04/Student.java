package com.itheima_04;

/*
    学生类
 */
public class Student {
    //成员变量
    String name;
//    int age;
    private int age;

    //提供get/set方法
    public void setAge(int a) {
//        age = a;

        if(a<0 || a>120) {
            System.out.println("你给的年龄有误");
        } else {
            age = a;
        }
    }

    public int getAge() {
        return age;
    }

    //成员方法
    public void show() {
        System.out.println(name + "," + age);
    }
}
