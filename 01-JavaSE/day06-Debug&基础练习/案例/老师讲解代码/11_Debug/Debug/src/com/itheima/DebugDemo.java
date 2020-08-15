package com.itheima;

/*
    Debug：
        是供程序员使用的程序调试工具，它可以用于查看程序的执行流程，也可以用于追踪程序执行过程来调试程序。
        Debug调试，又被称为断点调试，断点其实是一个标记，告诉我们从哪里开始查看。

    Debug操作流程：
        1:如何加断点
        2:如何运行加了断点的程序
        3:看哪里
        4:点哪里
        5:如何删除断点
 */
public class DebugDemo {
    public static void main(String[] args) {
        //定义两个变量
        int i = 10;
        int j = 20;

        //求和
        int sum = i + j;

        //输出结果
        System.out.println("sum:" + sum);
    }
}
