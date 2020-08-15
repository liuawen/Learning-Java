package com.itheima;

import java.util.Scanner;

/*
    查看方法调用的执行流程
 */
public class DebugTest02 {
    public static void main(String[] args) {
        //创建对象
        Scanner sc = new Scanner(System.in);

        //接收数据
        System.out.println("请输入第一个整数：");
        int a = sc.nextInt();

        System.out.println("请输入第二个整数：");
        int b = sc.nextInt();

        //调用方法
        int max = getMax(a, b);

        //输出结果
        System.out.println("较大的值是：" + max);
    }

    //获取两个数的较大值
    public static int getMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}
