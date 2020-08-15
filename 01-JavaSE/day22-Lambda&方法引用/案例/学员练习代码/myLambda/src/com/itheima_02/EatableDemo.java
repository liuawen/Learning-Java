package com.itheima_02;

/*
    Lambda表达式的格式：(形式参数) -> {代码块}

    练习1：
        1:定义一个接口(Eatable)，里面定义一个抽象方法：void eat();
        2:定义一个测试类(EatableDemo)，在测试类中提供两个方法
            一个方法是：useEatable(Eatable e)
            一个方法是主方法，在主方法中调用useEatable方法
 */
public class EatableDemo {
    public static void main(String[] args) {
        
    }

    private static void useEatable(Eatable e) {
        e.eat();
    }
}
