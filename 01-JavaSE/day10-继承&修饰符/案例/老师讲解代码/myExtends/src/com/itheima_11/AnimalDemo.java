package com.itheima_11;

/*
    测试类
 */
public class AnimalDemo {
    public static void main(String[] args) {
        //创建猫类对象并进行测试
        Cat c1 = new Cat();
        c1.setName("加菲猫");
        c1.setAge(5);
        System.out.println(c1.getName() + "," + c1.getAge());
        c1.catchMouse();

        Cat c2 = new Cat("加菲猫", 5);
        System.out.println(c2.getName() + "," + c2.getAge());
        c2.catchMouse();
    }
}
