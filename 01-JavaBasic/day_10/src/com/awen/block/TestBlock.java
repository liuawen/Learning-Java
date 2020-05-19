package com.awen.block;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-18
 * 非静态代码块中的代码什么时候执行呢
 * 在创建对象的时候执行
 * 比构造器早
 *
 * 在每次创建对象的时候执行
 *
 * 实例初始化过程 创建对象时 为对象进行初始化的操作
 * 1、为成员变量显示赋值
 * 2、执行非静态代码块
 * 3、执行构造器
 *
 * Java编译器其实 会把这三个部分的代码 合成一个 <init>
 *     形参列表 实例初始化方法
 *     即编译后的 .class字节码信息中
 *     是没有构造器这个概念
 *
 */
public class TestBlock {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        MyClass myClass1 = new MyClass("hello");
    }
}
class MyClass{
    private String str;
    public MyClass(String str){
        this.str = str;
        System.out.println("有参构造");
    }
    public MyClass(){
        System.out.println("无参构造");
    }
    //没名字怎么执行呢 我先创建个对象看一看执行了
    {
        System.out.println("非静态代码块");
    }
}