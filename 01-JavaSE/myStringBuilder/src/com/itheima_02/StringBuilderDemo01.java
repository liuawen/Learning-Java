package com.itheima_02;
/*
    StringBuilder 的添加和反转方法
        public StringBuilder append(任意类型)：添加数据，并返回对象本身
        append 添加
        public StringBuilder reverse()：返回相反的字符序列
        reverse 反转
 */
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        //创建对象
        StringBuilder sb = new StringBuilder();
        System.out.println("sb:" + sb );//sb:
//        public StringBuilder append(任意类型)：添加数据，并返回对象本身
        StringBuilder sb2 = sb.append("hello");

        System.out.println("sb:" + sb);//sb:hello
        System.out.println("sb2:" + sb2);//sb2:hello
        System.out.println(sb == sb2);//true

        sb.append("hello");
        sb.append("world");
        sb.append("java");
        sb.append(100);

        //链式编程
//        sb.append("hello").append("world").append("java").append(100);

        System.out.println("sb:" + sb);//sb:hellohelloworldjava100

        //public StringBuilder reverse()：返回相反的字符序列
        sb.reverse();
        System.out.println("sb:" + sb);//sb:001avajdlrowolleholleh
    }
}
