package com.itheima_02;
/*
    StringBuilder 转换为 String
        public String toString()：通过 toString() 就可以实现把 StringBuilder 转换为 String

    String 转换为 StringBuilder
        public StringBuilder(String s)：通过构造方法就可以实现把 String 转换为 StringBuilder
 */
public class StringBuilderDemo02 {
    public static void main(String[] args) {
        /*
        //StringBuilder 转换为 String
        StringBuilder sb = new StringBuilder();
        sb.append("hello");

//        String s = sb; //这个是错误的做法

        //public String toString()：通过 toString() 就可以实现把 StringBuilder 转换为 String
        String s = sb.toString();
        System.out.println(s);
        */

        //String 转换为 StringBuilder
        String s = "hello";

//        StringBuilder sb = s; //这个是错误的做法

        //public StringBuilder(String s)：通过构造方法就可以实现把 String 转换为 StringBuilder
        StringBuilder sb = new StringBuilder(s);

        System.out.println(sb);
    }
}
