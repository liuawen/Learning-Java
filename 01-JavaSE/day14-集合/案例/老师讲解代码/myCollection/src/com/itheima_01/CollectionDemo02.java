package com.itheima_01;

import java.util.ArrayList;
import java.util.Collection;

/*
    Collection集合常用方法:
        boolean add(E e):添加元素
        boolean remove(Object o):从集合中移除指定的元素
        void clear():清空集合中的元素
        boolean contains(Object o):判断集合中是否存在指定的元素
        boolean isEmpty():判断集合是否为空
        int size():集合的长度，也就是集合中元素的个数

    Alt+7   打开一个窗口，能够看到类的所有信息
 */
public class CollectionDemo02 {
    public static void main(String[] args) {
        //创建集合对象
        Collection<String> c = new ArrayList<String>();

        //boolean add(E e):添加元素
//        System.out.println(c.add("hello"));
//        System.out.println(c.add("world"));
//        System.out.println(c.add("world"));
        c.add("hello");
        c.add("world");
        c.add("java");

        //boolean remove(Object o):从集合中移除指定的元素
//        System.out.println(c.remove("world"));
//        System.out.println(c.remove("javaee"));

        //void clear():清空集合中的元素
//        c.clear();

        //boolean contains(Object o):判断集合中是否存在指定的元素
//        System.out.println(c.contains("world"));
//        System.out.println(c.contains("javaee"));

        //boolean isEmpty():判断集合是否为空
//        System.out.println(c.isEmpty());

        //int size():集合的长度，也就是集合中元素的个数
        System.out.println(c.size());


        //输出集合对象
        System.out.println(c);
    }
}
