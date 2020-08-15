package com.itheima_10;

public class Teacher extends Person {

    public Teacher() {}

    public Teacher(String name,int age) {
//        this.name = name;
//        this.age = age;
        super(name,age);
    }

    public void teach() {
        System.out.println("用爱成就每一位学员");
    }

}
