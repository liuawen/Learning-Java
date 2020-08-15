package com.itheima_01;

/*
    JVM的默认处理方案
 */
public class ExceptionDemo02 {
    public static void main(String[] args) {
        System.out.println("开始");
        method();
        System.out.println("结束");
    }

    public static void method() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[1]);
    }
}
