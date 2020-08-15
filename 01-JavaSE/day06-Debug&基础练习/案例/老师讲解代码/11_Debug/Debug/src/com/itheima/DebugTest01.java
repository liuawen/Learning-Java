package com.itheima;

/*
    查看循环求偶数和的执行流程
 */
public class DebugTest01 {
    public static void main(String[] args) {
        //定义求和变量
        int sum = 0;

        //循环求偶数和
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        //输出结果
        System.out.println("1-10之间的偶数和是：" + sum);
    }
}