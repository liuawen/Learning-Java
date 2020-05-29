package cn.liuawen.test;

import java.util.ArrayList;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-28
 */
public class CollectionTest06 {
    public static void main(String[] args) {
        //定义集合，添加数据
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(listTest(list, 5));//4
    }

    public static int listTest(ArrayList<Integer> al, Integer s) {
        //遍历集合，获取元素，判断元素是否与s相等，相等返回索引
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).equals(s)) {
                return i;
            }
        }
        return -1;
    }
}
