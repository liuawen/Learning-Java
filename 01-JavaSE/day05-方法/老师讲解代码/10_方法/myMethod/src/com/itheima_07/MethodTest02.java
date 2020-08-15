package com.itheima_07;

/*
    数组最大值

    需求：
        设计一个方法用于获取数组中元素的最大值，调用方法并输出结果

    思路：
        1:定义一个数组，用静态初始化完成数组元素初始化
        2:定义一个方法，用来获取数组中的最大值
        3:调用获取最大值方法，用变量接收返回结果
        4:把结果输出在控制台
 */
public class MethodTest02 {
    public static void main(String[] args) {
        //定义一个数组，用静态初始化完成数组元素初始化
        int[] arr = {12, 45, 98, 73, 60};

        //调用获取最大值方法，用变量接收返回结果
        int number = getMax(arr);

        //把结果输出在控制台
        System.out.println("number:" + number);
    }

    //定义一个方法，用来获取数组中的最大值
    /*
        两个明确：
            返回值类型：int
            参数：int[] arr
     */
    public static int getMax(int[] arr) {
        int max = arr[0];

        for(int x=1; x<arr.length; x++) {
            if(arr[x] > max) {
                max = arr[x];
            }
        }

        return max;
    }

}
