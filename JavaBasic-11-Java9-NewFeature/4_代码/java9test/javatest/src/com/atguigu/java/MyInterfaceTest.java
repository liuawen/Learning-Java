package com.atguigu.java;

/**
 * Created by songhongkang on 2017/12/29 0029.
 * 1.
 * 类：人
 * 接口：兽  --->半兽人
 *
 * 2. 面试题：抽象类 和 接口的异同？
 *   ①二者的定义： a.声明的方式   b.内部的结构（jdk 7 ;jdk 8 ; jdk 9)
 *   ②共同点：不能实例化；以多态的方式使用
 *   ③不同点：单继承 ； 多实现
 */

interface MyInterface{

    //jdk 7 : 只能声明全局常量(public static final)和抽象方法(public abstract)
    void method1();

    // jdk 8 : 声明静态方法 和 默认方法
    public static void method2(){
        System.out.println("method2");
    }

    default void method3(){
        System.out.println("method3");
        method4();
    }

    //jdk 9 : 声明私有方法
    private void method4(){
        System.out.println("私有方法");
    }


}

class MyInterfaceImpl implements  MyInterface{

    @Override
    public void method1() {
        System.out.println("实现接口中的抽象方法method1()");
    }
}

public class MyInterfaceTest {
    public static void main(String[] args) {
        MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.method3();

//        impl.method4();
    }
}
