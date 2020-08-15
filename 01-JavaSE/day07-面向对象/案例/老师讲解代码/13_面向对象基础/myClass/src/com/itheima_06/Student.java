package com.itheima_06;

/*
    学生类
 */
public class Student {
    private String name;
    private int age;

//    public void setName(String n) {
//        name = n;
//    }

    public void setName(String name) {
//        name = name;
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public void setAge(int a) {
//        age = a;
//    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void show() {
        System.out.println(name + "," + age);
    }
}
