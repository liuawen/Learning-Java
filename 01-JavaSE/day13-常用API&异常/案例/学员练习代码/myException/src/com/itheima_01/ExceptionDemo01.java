package com.itheima_01;

/*
    异常
 */
public class ExceptionDemo01 {
    public static void main(String[] args) {
        method();
    }

    public static void method() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[1]);
    }
}
