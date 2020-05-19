package com.awen.test03;

import java.util.Scanner;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-19
 */

/*
 * 异常：
 * 	不正常
 *  在某些情况下，因为用户的一些原因，例如：配置问题、错误输入的问题、用户磁盘空间满了等因素，导致程序无法正常运行。
 *
 *  不是异常：（1）语法错误（2）逻辑错误
 *
 * Java的程序如果出现异常，并且在代码中，没有做相应的处理，那么程序会“崩溃”，“挂了”
 *
 * Java如何处理异常？或Java异常处理的过程？
 * （1）当程序运行到某一句时，发生了异常，那么程序会先停下来
 * （2）程序会在这句代码处，查看原因，生成一个合理“异常对象”，然后“抛”出
 * （3）JVM会检测在这句代码的外围，是否有try..catch结构，可以“捕获”它，
 * 如果可以捕获，那么程序再处理完异常后，继续下面的运行，不会崩溃；
 * 如果不能捕获，那么会把这个异常继续抛给“上级”，如果“上级”能处理，那么程序从“上级"处理完的代码后面继续运行；
 * 如果上级也不能处理，那么继续往上抛，一直到达JVM，那么就“崩溃”
 *
 * 一次次处理 向上搞
 */
public class TestException {
    public static void main(String[] args) {
//		System.out.println(a);//语法错误
        //不是异常 语法错误 逻辑异常
        int sum = getSum(1,2);
        System.out.println("sum = " + sum);

        try {
            testInput();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("main的其他代码");
    }

    public static void testInput(){
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("请输入一个整数：");
            int num = input.nextInt();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("输入有误");//这里 只是提醒，没有让他 重新输入
        }

        System.out.println("其他的代码");
    }


    //求两个整数的和
    public static int getSum(int a ,int b){
        return a - b;
    }
}
