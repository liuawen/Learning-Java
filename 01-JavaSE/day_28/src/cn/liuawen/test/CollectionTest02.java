package cn.liuawen.test;

import java.util.ArrayList;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-28
 * 定义一个方法，要求此方法把int数组转成存有相同元素的集合(集合里面的元素是Integer)，
 * 并返回。()
 */
public class CollectionTest02 {
    public static void main(String[] args) {
        //定义int数组
        int[] arr = {1, 2, 3, 4, 5};
        ArrayList<Integer> list = listTest(arr);
        System.out.println(list);//[1, 2, 3, 4, 5]
    }

    public static ArrayList<Integer> listTest(int[] arr) {
        //定义集合
        ArrayList<Integer> list = new ArrayList<Integer>();
        //遍历数组，把元素依次添加到集合当中
        for (int a : arr) {
            list.add(a);
        }
        return list;
    }
}

