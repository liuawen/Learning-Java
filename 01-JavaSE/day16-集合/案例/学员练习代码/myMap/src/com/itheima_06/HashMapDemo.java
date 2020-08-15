package com.itheima_06;

/*
    需求：
        键盘录入一个字符串，要求统计字符串中每个字符串出现的次数。
        举例：键盘录入“aababcabcdabcde”	在控制台输出：“a(5)b(4)c(3)d(2)e(1)”

    思路：
        1:键盘录入一个字符串
        2:创建HashMap集合，键是Character，值是Integer
        3:遍历字符串，得到每一个字符
        4:拿得到的每一个字符作为键到HashMap集合中去找对应的值，看其返回值
            如果返回值是null：说明该字符在HashMap集合中不存在，就把该字符作为键，1作为值存储
            如果返回值不是null：说明该字符在HashMap集合中存在，把该值加1，然后重新存储该字符和对应的值
        5:遍历HashMap集合，得到键和值，按照要求进行拼接
        6:输出结果
 */
public class HashMapDemo {
    public static void main(String[] args) {
        
    }
}
