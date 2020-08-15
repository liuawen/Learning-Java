package com.itheima_05;

/*
    方法重载：
        多个方法在同一个类中
        多个方法具有相同的方法名
        多个方法的参数不相同，类型不同或者数量不同

        与返回值无关
        在调用的时候，Java虚拟机会通过参数的不同来区分同名的方法
 */
public class MethodDemo {
    public static void main(String[] args) {
        //调用方法
        int result = sum(10,20);
        System.out.println(result);

        double result2 = sum(10.0,20.0);
        System.out.println(result2);

        int result3 = sum(10,20,30);
        System.out.println(result3);
    }

    //需求1：求两个int类型数据和的方法
    public static int sum(int a, int b) {
        return a + b;
    }

    //需求2：求两个double类型数据和的方法
    public static double sum(double a, double b) {
        return a + b;
    }

    //需求3：求三个int类型数据和的方法
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

}
