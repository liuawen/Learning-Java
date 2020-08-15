package com.itheima;


import java.util.Scanner;

/*
    需求：输入星期数，显示今天的减肥活动
            周一：跑步
            周二：游泳
            周三：慢走
            周四：动感单车
            周五：拳击
            周六：爬山
            周日：好好吃一顿

    思路：
        1:键盘录入一个星期数，用一个变量接收
        2:对星期数进行判断，这里用 switch 语句实现
        3:在对应的语句控制中输出对应的减肥活动

    导包：
        1:手动导包  import java.util.Scanner;
        2:快捷键导包 Alt+Enter
        3:自动导包
 */
public class Test02 {
    public static void main(String[] args) {
        //键盘录入一个星期数，用一个变量接收
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个星期数：");
        int week = sc.nextInt();

        //对星期数进行判断，这里用 switch 语句实现
        
    }
}
