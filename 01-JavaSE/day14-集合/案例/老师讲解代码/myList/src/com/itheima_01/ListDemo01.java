package com.itheima_01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
    List集合特点
        有序：存储和取出的元素顺序一致
        可重复：存储的元素可以重复
 */
public class ListDemo01 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();

        //添加元素
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("world");

        //输出集合对象
//        System.out.println(list);

        //迭代器的方式遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

    }
}
