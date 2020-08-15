package com.itheima_02;
/*
    测试类
 */
public class InnerDemo {
    public static void main(String[] args) {
        //创建内部类对象，并调用方法
//        Inner i = new Inner();

//        Outer.Inner oi = new Outer().new Inner();
//        oi.show();

        Outer o = new Outer();
        o.method();

    }
}
