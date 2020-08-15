package com.itheima_07;

import java.util.ArrayList;
import java.util.LinkedList;

/*
    List集合常用子类：ArrayList，LinkedList
        ArrayList：底层数据结构是数组，查询快，增删慢
        LinkedList：底层数据结构是链表，查询慢，增删快

    练习：
        分别使用ArrayList和LinkedList完成存储字符串并遍历
 */
public class ListDemo {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<String> array = new ArrayList<String>();

        array.add("hello");
        array.add("world");
        array.add("java");

        //遍历
        for (String s : array) {
            System.out.println(s);
        }
        //剩下两种遍历方式大家补齐
        System.out.println("--------");

        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("hello");
        linkedList.add("world");
        linkedList.add("java");

        for(String s : linkedList) {
            System.out.println(s);
        }
        //剩下两种遍历方式大家补齐
    }
}
