package com.itheima_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
    需求：
        ArrayList存储学生对象，使用Collections对ArrayList进行排序
        要求：按照年龄从小到大排序，年龄相同时，按照姓名的字母顺序排序

    思路：
        1:定义学生类
        2:创建ArrayList集合对象
        3:创建学生对象
        4:把学生添加到集合
        5:使用Collections对ArrayList集合排序
        6:遍历集合
 */
public class CollectionsDemo02 {
    public static void main(String[] args) {
        //创建ArrayList集合对象
        ArrayList<Student> array = new ArrayList<Student>();

        //创建学生对象
        Student s1 = new Student("linqingxia", 30);
        Student s2 = new Student("zhangmanyu", 35);
        Student s3 = new Student("wangzuxian", 33);
        Student s4 = new Student("liuyan", 33);

        //把学生添加到集合
        array.add(s1);
        array.add(s2);
        array.add(s3);
        array.add(s4);

        //使用Collections对ArrayList集合排序
        //sort​(List<T> list, Comparator<? super T> c)
        Collections.sort(array, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //按照年龄从小到大排序，年龄相同时，按照姓名的字母顺序排序
                int num = s1.getAge() - s2.getAge();
                int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
                return num2;
            }
        });

        //遍历集合
        for (Student s : array) {
            System.out.println(s.getName() + "," + s.getAge());
        }

    }
}
