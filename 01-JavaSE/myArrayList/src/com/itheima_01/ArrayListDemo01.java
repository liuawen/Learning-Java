package com.itheima_01;

import java.util.ArrayList;

/*
    ArrayList构造方法：
        public ArrayList​()：创建一个空的集合对象

    ArrayList添加方法：
        public boolean add(E e)：将指定的元素追加到此集合的末尾
        public void add(int index,E element)：在此集合中的指定位置插入指定的元素
 */
public class ArrayListDemo01 {
    public static void main(String[] args) {
        //public ArrayList​()：创建一个空的集合对象
//        ArrayList<String> array = new ArrayList<>();

        ArrayList<String> array = new ArrayList<String>();

        //public boolean add(E e)：将指定的元素追加到此集合的末尾
//        System.out.println(array.add("hello"));

        array.add("hello");
        array.add("world");
        array.add("java");

        //public void add(int index,E element)：在此集合中的指定位置插入指定的元素
        array.add(1,"javase");
//        array.add(3,"javaee");

        //IndexOutOfBoundsException
//        array.add(4,"javaee");

        //输出集合
        System.out.println("array:" + array);//array:[hello, javase, world, java]

    }
}
