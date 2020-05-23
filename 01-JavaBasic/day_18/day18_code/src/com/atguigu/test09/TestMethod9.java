package com.atguigu.test09;

import java.util.Arrays;

import org.junit.Test;

/*
 * 方法系列（9）：拆分
 * String[] split(xx)
 */
public class TestMethod9 {
    @Test
    public void test4() {
        String str = "张三.23|李四.24|王五.25";
        //|在正则中是有特殊意义，我这里要把它当做普通的|
        String[] all = str.split("\\|");

        //转成一个一个学生对象
        Student[] students = new Student[all.length];
        for (int i = 0; i < students.length; i++) {
            //.在正则中是特殊意义，我这里想要表示普通的.
            String[] strings = all[i].split("\\.");//张三,  23
            String name = strings[0];
            int age = Integer.parseInt(strings[1]);
            students[i] = new Student(name, age);
        }

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
        //Student [name=张三, age=23]
        //Student [name=李四, age=24]
        //Student [name=王五, age=25]

    }

    @Test
    public void test3() {
        String str = "1Hello2World3java4菜鸡5";
        str = str.replaceAll("^\\d|\\d$", "");
        String[] all = str.split("\\d");
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }
        //Hello
        //World
        //java
        //菜鸡
    }

    @Test
    public void test2() {
        String str = "1Hello2World3java4菜鸡";
        str = str.replaceFirst("\\d", "");
        System.out.println(str);
        String[] all = str.split("\\d");
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }
        //Hello2World3java4菜鸡
        //Hello
        //World
        //java
        //菜鸡
    }


    @Test
    public void test1() {
        String str = "Hello World java 菜鸡 菜牛";
        String[] all = str.split(" ");
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }
        //Hello
        //World
        //java
        //菜鸡
        //菜牛
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Student() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

}