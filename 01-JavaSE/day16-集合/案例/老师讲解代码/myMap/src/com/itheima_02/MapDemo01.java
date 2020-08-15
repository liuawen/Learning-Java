package com.itheima_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    Map集合的遍历(方式1):
        1:获取所有键的集合。用keySet()方法实现
        2:遍历键的集合，获取到每一个键。用增强for实现
        3:根据键去找值。用get(Object key)方法实现
 */
public class MapDemo01 {
    public static void main(String[] args) {
        //创建集合对象
        Map<String, String> map = new HashMap<String, String>();

        //添加元素
        map.put("张无忌", "赵敏");
        map.put("郭靖", "黄蓉");
        map.put("杨过", "小龙女");

        //获取所有键的集合。用keySet()方法实现
        Set<String> keySet = map.keySet();
        //遍历键的集合，获取到每一个键。用增强for实现
        for (String key : keySet) {
            //根据键去找值。用get(Object key)方法实现
            String value = map.get(key);
            System.out.println(key + "," + value);
        }
    }
}
