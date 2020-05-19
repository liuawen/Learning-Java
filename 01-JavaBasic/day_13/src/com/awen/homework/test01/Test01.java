package com.awen.homework.test01;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-19
 */
/*
 * 考核点：多态，重载，重写
 * 1、分析每个类都有什么方法
 * A类：
 *   public String show(D obj)
 *   public String show(A obj)
 * B类：
 * 	 public String show(D obj)
 *   public String show(A obj)重写
 *   public String show(B obj)
 * C类和D类，因为这里没有用它们的对象去调用方法，暂时不分析。
 *
 * 2、继承关系
 * C-->B-->A
 * D-->B-->A
 *
 * 3、如果出现重载的多个方法，会找其中类型最合适的
 *
 * 4、分析代码
 * （1）a1.show(b)，因为这里a1没有多态引用，编译时类型和运行时类型都是A类，只看A类的方法。
 * 此时b对象是B类型，那么public String show(A obj)这个方法最合适，因为b不能赋值给D子类的形参，只能自动向上转型为A类
 *
 * （2）a2.show(d)，因为这里a2有多态，编译时类型是从A类型中寻找最合适的方法，运行时执行的B类的重写的方法，如果B类没有重写，还是执行的是A类的
 * 此时d对象是D类型，在A类中public String show(D obj)这个方法最合适。
 *
 * （3）b.show(c)，因为b没有多态，编译时类型和运行时类型都是B类，从B类中选择最合适的方法
 * 此时c对象是C类型，在B类中public String show(B obj)最合适的，因为C与B最近，比与A近
 *
 * （4）b.show(d)，因为b没有多态，编译时类型和运行时类型都是B类，从B类中选择最合适的方法
 * 此时d对象是D类型，在B类中public String show(D obj)最合适
 */
public class Test01 {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println("(1)" + a1.show(b));//A and A
        System.out.println("(2)" + a2.show(d));//A and D
        System.out.println("(3)" + b.show(c));//B and B
        System.out.println("(4)" + b.show(d));//A and D
    }
}
class A{
    public String show(D obj){
        return ("A and D");
    }
    public String show(A obj){
        return "A and A";
    }
}
class B extends A{
    public String show(B obj){
        return "B and B";
    }
    public String show(A obj){
        return "B and A";
    }
}
class C extends B{

}
class D extends B{

}