package com.itheima_02;

/*
    需求：
        设计一个方法用于打印两个数中的较大数，数据来自于方法参数

    思路：
        1:定义一个方法，用于打印两个数字中的较大数，例如getMax()
        2:为方法定义两个参数，用于接收两个数字
        3:使用分支语句分两种情况对两个数字的大小关系进行处理
        4:在main()方法中调用定义好的方法（使用常量）
        5:在main()方法中调用定义好的方法（使用变量）
 */
public class MethodTest {
    public static void main(String[] args) {
        //在main()方法中调用定义好的方法（使用常量）
        getMax(10,20);
        //调用方法的时候，人家要几个，你就给几个，人家要什么类型的，你就给什么类型的
        //getMax(30);
        //getMax(10.0,20.0);

        //在main()方法中调用定义好的方法（使用变量）
        int a = 10;
        int b = 20;
        getMax(a, b);
    }

    //定义一个方法，用于打印两个数字中的较大数，例如getMax()
    //为方法定义两个参数，用于接收两个数字
    public static void getMax(int a, int b) {
        //使用分支语句分两种情况对两个数字的大小关系进行处理
        if(a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

}
