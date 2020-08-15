package com.itheima_03;

/*
    测试类
 */
public class AnimalDemo {
    public static void main(String[] args) {
        //创建动物操作类的对象，调用方法
        AnimalOperator ao = new AnimalOperator();
        Cat c = new Cat();
        ao.useAnimal(c);


        Dog d = new Dog();
        ao.useAnimal(d);


        Pig p = new Pig();
        ao.useAnimal(p);

    }
}
