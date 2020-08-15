package com.itheima_03;

import java.util.ArrayList;

/*
    Stream<T> limit​(long maxSize)：返回此流中的元素组成的流，截取前指定参数个数的数据
    Stream<T> skip​(long n)：跳过指定参数个数的数据，返回由该流的剩余元素组成的流
 */
public class StreamDemo02 {
    public static void main(String[] args) {
        //创建一个集合，存储多个字符串元素
        ArrayList<String> list = new ArrayList<String>();

        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        //需求1：取前3个数据在控制台输出


        //需求2：跳过3个元素，把剩下的元素在控制台输出


        //需求3：跳过2个元素，把剩下的元素中前2个在控制台输出

    }
}
