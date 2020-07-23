package com.awen.test01;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-19
 */
/*
 * 一、如何声明接口？
 * 1、接口的语法格式：
 * 【权限修饰符】  interface 接口名{
 * 		接口的成员列表;
 * }
 *权限修饰符 interface 接口名{
 *      接口的成员列表;
 * }
 * 2、接口的成员
 * JDK1.8之前：只能有两种成员
 * （1）全局的静态的常量：public static final，而且这三个单词可以省略
 * 为什么只能是常量？
 * 因为标准中，只能写定死的
 *
 * （2）公共的抽象的方法：public abstract，而且这两个单词可以省略
 * 为什么只能是抽象方法？
 * 标准中只规定有什么行为标准，行为特征。至于你怎么实现，那么你自己说了算。
 *抽象方法  怎么实现  你自己说了算
 * 二、 如何实现接口？
 * 语法格式：
 * 【修饰符】 class 实现类    implements 父接口们{
 * }
 *
 * 三、接口的特点
 * 1、接口是标准，就是用来被遵守的，即就是用来被实现的，那么要求实现类在实现接口时，必须实现/重写所有的抽象方法，
 * 否则这个实现类就得是一个抽象类。
 * 2、接口也是不能直接创建对象的
 * 3、接口类型的变量与实现类的对象构成多态引用
 * 4、一个类继承父类时，我们说Java只支持单继承，但是一个类在实现接口时，可以同时实现多个接口
 * 5、一个类如果同时继承父类，又实现接口时，要求继承在前，实现在后
 * 【修饰符】 class 实现类  extends 父类   implements 父接口们{
 * }
 * 6、在Java中，接口还可以继承接口
 * 【权限修饰符】 interface 子接口   extends 父接口们{
 * }
 */

public class TestInterfaceDefineAndUse {
    public static void main(String[] args) {
//		Flyable f = new Flyable();//接口不能直接创建对象的
        Flyable[] sky = new Flyable[3];
        //数组的元素类型Flyable类型，是接口类型
        sky[0] = new Bird();//多态引用
        sky[1] = new Plane();
        sky[2] = new Kite();

        for (int i = 0; i < sky.length; i++) {
            //数组的元素类型Flyable类型，是接口类型
            sky[i].fly();
        }
    }
}
//声明一个Flyable接口
interface Flyable{
    //	public static final long MAX_SPEED = 7900000;
    long MAX_SPEED = 7900000;

    //	public abstract void fly();
    void fly();
}
//声明一个Jumpable接口
interface Jumpable{
    void jump();
}
class Animal{

}
//让小鸟继承Animal，并实现Flyable和Jumpable
class Bird extends Animal implements Flyable,Jumpable {

    //重写接口的抽象方法，实现接口的抽象方法
    @Override
    public void fly() {
        System.out.println("小鸟振翅高飞");
    }

    @Override
    public void jump() {
        System.out.println("双脚跳");
    }

}
class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("靠发动机带动飞行");
    }

}
class Kite implements Flyable{

    @Override
    public void fly() {
        System.out.println("靠人放");
    }

}

interface A{
    void a();
}
interface B{
    void b();
}
interface C extends A,B{
    void c();
}
class Impl implements C{

    @Override
    public void a() {
    }

    @Override
    public void b() {
    }

    @Override
    public void c() {
    }

}