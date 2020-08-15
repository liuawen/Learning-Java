package com.itheima_03;

/*
    单个对象
 */
public class StudentTest01 {
    public static void main(String[] args) {
        //创建对象
        Student s = new Student();
        System.out.println(s);

        //使用成员变量
        System.out.println(s.name + "," + s.age);

        s.name = "张曼玉";
        s.age = 28;

        System.out.println(s.name + "," + s.age);

        //使用成员方法
        s.study();
        s.doHomework();
    }
}
