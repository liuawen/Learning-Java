package com.itheima_01;

/*
    测试类
 */
public class StaticDemo {
    public static void main(String[] args) {

        Student.university = "传智大学";

        Student s1 = new Student();
        s1.name = "林青霞";
        s1.age = 30;
//        s1.university = "传智大学";
        s1.show();

        Student s2 = new Student();
        s2.name = "风清扬";
        s2.age = 33;
//        s2.university = "传智大学";
        s2.show();
    }
}
