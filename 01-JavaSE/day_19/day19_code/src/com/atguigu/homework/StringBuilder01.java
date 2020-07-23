package com.atguigu.homework;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-25
 */
public class StringBuilder01 {
    public static void main(String[] args) {
        //使用System的currentTimeMillis()方法获取当前操作系统的毫秒值,作用程序执行的开始时间,使用start变量接收
        long start = System.currentTimeMillis();
        //需要测试执行性能的代码
        //testString(); //消耗时间: 29295毫秒
        testStringBuilder();//消耗时间:6毫秒
        //使用System的currentTimeMillis()方法获取当前操作系统的毫秒值,作用程序执行的结束时间,使用end变量接收
        long end = System.currentTimeMillis();
        //计算代码执行花费的时间 end - start,输出代码执行消耗的时间
        System.out.println("所花费的时间为:" + (end - start));
    }

    //写一个静态方法: testString(),在该方法中
    public static void testString() {
        //定义一个字符串 str,内容随意
        String str = "hello";
        //写一个循环100000次for循环,在循环中写上
        for (int i = 0; i < 100000; i++) {
            //str +=”随机内容” ; 这里不要写str += (str+”xxx”) 这样会导致堆内存溢出错误.
            str += "world";
        }
    }

    //写一个静态方法:testStringBuilder(),在方法中
    public static void testStringBuilder() {
        //创建一个StringBuilder对象sb,初始内容与testString()中的字符串相同
        StringBuilder sb = new StringBuilder("hello");
        //写一个循环100000次for循环,在循环中写上
        for (int i = 0; i < 100000; i++) {
            //调用sb.append()方法,传入的内容与testString()方法中+=后面的内容一样
            sb.append("world");
        }
        //循环结束调用sb.toString()方法转换为字符串
        String newStr = sb.toString();
    }
}