package com.itheima_01;

/*
    递归概述：
        以编程的角度来看，递归指的是方法定义中调用方法本身的现象
 */
public class DiGuiDemo {
    public static void main(String[] args) {
        //回顾不死神兔问题，求第20个月兔子的对数
        //每个月的兔子对数：1,1,2,3,5,8，...
        int[] arr = new int[20];

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[19]);

    }
}
