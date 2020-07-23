package cn.liuawen.test;

import java.util.ArrayList;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-28
 * 定义一个方法listTest(ArrayList<String> al), 要求使用isEmpty()判断al里面是否有元素。
 */
public class CollectionTest05 {
    public static void main(String[] args) {
        //定义集合，添加数据
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.remove(0);
        System.out.println(listTest(list));//true
    }

    public static boolean listTest(ArrayList<String> al) {
        //判断al集合是否为空,为空返回true，不为空返回false
        if (al.isEmpty()) {
            return true;
        }
        return false;
    }
}
