package com.itheima_03;

/*
    Lambda表达式的格式：(形式参数) -> {代码块}

    练习2：
        1:定义一个接口(Flyable)，里面定义一个抽象方法：void fly(String s);
        2:定义一个测试类(FlyableDemo)，在测试类中提供两个方法
            一个方法是：useFlyable(Flyable f)
            一个方法是主方法，在主方法中调用useFlyable方法
 */
public class FlyableDemo {
    public static void main(String[] args) {
    

    }

    private static void useFlyable(Flyable f) {
        f.fly("风和日丽，晴空万里");
    }
}
