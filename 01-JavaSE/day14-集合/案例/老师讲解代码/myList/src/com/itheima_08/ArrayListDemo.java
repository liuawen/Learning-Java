package com.itheima_08;

import java.util.ArrayList;
import java.util.Iterator;

/*
    需求：
        创建一个存储学生对象的集合，存储3个学生对象，使用程序实现在控制台遍历该集合

    思路：
        1:定义学生类
        2:创建ArrayList集合对象
        3:创建学生对象
        4:把学生添加到集合
        5:遍历集合
            迭代器：集合特有的遍历方式
            普通for：带有索引的遍历方式
            增强for：最方便的遍历方式
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        //创建ArrayList集合对象
        ArrayList<Student> array = new ArrayList<Student>();

        //创建学生对象
        Student s1 = new Student("林青霞", 30);
        Student s2 = new Student("张曼玉", 35);
        Student s3 = new Student("王祖贤", 33);

        //把学生添加到集合
        array.add(s1);
        array.add(s2);
        array.add(s3);

        //迭代器：集合特有的遍历方式
        Iterator<Student> it = array.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            System.out.println(s.getName() + "," + s.getAge());
        }
        System.out.println("--------");

        //普通for：带有索引的遍历方式
        for(int i=0; i<array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getName() + "," + s.getAge());
        }
        System.out.println("--------");

        //增强for：最方便的遍历方式
        for(Student s : array) {
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
}
