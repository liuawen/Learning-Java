package com.itheima_06;

/*
    测试类
 */
public class ArgsDemo01 {
    public static void main(String[] args) {
        System.out.println(sum(10, 20));
        System.out.println(sum(10, 20, 30));
        System.out.println(sum(10, 20, 30, 40));

//        System.out.println(sum(10,20,30,40,50));
//        System.out.println(sum(10,20,30,40,50,60));
//        System.out.println(sum(10,20,30,40,50,60,70));

    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static int sum(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}
