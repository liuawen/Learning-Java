package com.itheima_03;

/*
    多个对象
 */
public class StudentTest02 {
    public static void main(String[] args) {
        //创建第一个对象并使用
        Student s1 = new Student();

        s1.name = "林青霞";
        s1.age = 30;
        System.out.println(s1.name + "," + s1.age);

        s1.study();
        s1.doHomework();

        //创建第二个对象并使用
        Student s2 = new Student();

        s2.name = "张曼玉";
        s2.age = 28;
        System.out.println(s2.name + "," + s2.age);

        s2.study();
        s2.doHomework();
    }
}
