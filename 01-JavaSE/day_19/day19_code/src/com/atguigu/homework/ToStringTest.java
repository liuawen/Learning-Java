package com.atguigu.homework;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-25
 */
public class ToStringTest {
    static int i = 1;

    public static void main(String args[]) {
        System.out.println("hello world");//hello world
        System.out.println("love " + new ToStringTest());//love java
        ToStringTest a = new ToStringTest();
        a.i++;
        System.out.println("me " + a.i);//me 2
        //Result
        //hello world
        //ToStringTest的无参构造
        //I love java
        //ToStringTest的无参构造
        //me 2
    }

    public ToStringTest() {
        System.out.println("ToStringTest的无参构造");
    }

    public String toString() {
        System.out.print("I ");//I
        return "java ";
    }
}