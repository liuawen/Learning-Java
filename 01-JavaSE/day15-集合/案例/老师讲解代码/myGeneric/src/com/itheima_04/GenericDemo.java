package com.itheima_04;

/*
    测试类
 */
public class GenericDemo {
    public static void main(String[] args) {
        Generic<String> g1 = new GenericImpl<String>();
        g1.show("林青霞");

        Generic<Integer> g2 = new GenericImpl<Integer>();
        g2.show(30);
    }
}
