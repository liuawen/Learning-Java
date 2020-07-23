package cn.liuawen.test;

import java.util.ArrayList;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-28
 * 定义一个方法listTest(ArrayList<String> al, String s),
 * 要求使用contains()方法判断al集合里面是否包含s。
 */
public class CollectionTest04 {
    public static void main(String[] args) {
        //定义集合，添加数据
        ArrayList<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(listTest(list, "java"));
    }

    public static boolean listTest(ArrayList<String> al, String s) {
        //判断s是否在集合中存在,存在返回true，不存在返回false
        if (al.contains(s)) {
            return true;
        }
        return false;
    }
}

