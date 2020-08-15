package com.itheima_03;

/*
    测试类
 */
public class JumppingDemo {
    public static void main(String[] args) {
        //创建操作类对象，并调用方法
        JumppingOperator jo = new JumppingOperator();
        Jumpping j = new Cat();
        jo.useJumpping(j);

        Jumpping j2 = jo.getJumpping(); //new Cat()
        j2.jump();
    }
}
