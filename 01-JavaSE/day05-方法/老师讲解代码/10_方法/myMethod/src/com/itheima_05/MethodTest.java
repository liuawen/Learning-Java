package com.itheima_05;

/*
    需求：
        使用方法重载的思想，设计比较两个整数是否相同的方法，兼容全整数类型（byte,short,int,long）

    思路：
        1:定义比较两个数字的是否相同的方法compare()方法，参数选择两个int型参数
        2:定义对应的重载方法，变更对应的参数类型，参数变更为两个long型参数
        3:定义所有的重载方法，两个byte类型与两个short类型参数
        4:完成方法的调用，测试运行结果
 */
public class MethodTest {
    public static void main(String[] args) {
        //调用方法
        System.out.println(compare(10, 20));
        System.out.println(compare((byte) 10, (byte) 20));
        System.out.println(compare((short) 10, (short) 20));
        System.out.println(compare(10L, 20L));
    }

    //int
    public static boolean compare(int a, int b) {
        System.out.println("int");
        return a == b;
    }

    //byte
    public static boolean compare(byte a, byte b) {
        System.out.println("byte");
        return a == b;
    }

    //short
    public static boolean compare(short a, short b) {
        System.out.println("short");
        return a == b;
    }

    //long
    public static boolean compare(long a, long b) {
        System.out.println("long");
        return a == b;
    }

}
