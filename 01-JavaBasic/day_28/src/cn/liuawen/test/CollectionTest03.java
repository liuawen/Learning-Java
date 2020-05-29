package cn.liuawen.test;

import java.util.ArrayList;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create :  2020-05-28
 */
public class CollectionTest03 {
    public static void main(String[] args) {
        //定义集合,添加数据
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(200);
        list.add(300);
        //Object[] toArray()转换成一个Object数组
        Object[] obj =  list.toArray();
        // 遍历数组
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
        }
        //Result
        //100
        //200
        //300
    }
}
