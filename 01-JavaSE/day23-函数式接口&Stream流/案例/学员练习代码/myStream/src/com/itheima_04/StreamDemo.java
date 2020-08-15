package com.itheima_04;

import java.util.ArrayList;

/*
    Stream流的常见终结操作方法
        void forEach​(Consumer action)：对此流的每个元素执行操作
            Consumer接口中的方法	void accept​(T t)：对给定的参数执行此操作
        long count​()：返回此流中的元素数
 */
public class StreamDemo {
    public static void main(String[] args) {
        //创建一个集合，存储多个字符串元素
        ArrayList<String> list = new ArrayList<String>();

        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        //需求1：把集合中的元素在控制台输出


        //需求2：统计集合中有几个以张开头的元素，并把统计结果在控制台输出

    }
}
