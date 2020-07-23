package com.awen.test07;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-19
 */

/*
 * 枚举：JDK1.5就引入
 * 	  类似：列举，穷举，一一罗列
 * 	Java枚举：把某个类型的对象，全部列出来
 *枚举 穷举 一一罗列 列举
 * 当什么情况下会用到枚举类型？
 * 当某个类型的对象是固定的，有限的几个，那么就可以选择使用枚举。
 * 在整个系统的运行期间，有且只有这几个对象。
 *
 * 把某个类型的对象，全部列出来
 * 当什么情况下会用到枚举类型
 * 例如：
 * 	性别  Gender，它的对象只有三个：男，女，妖
 *  星期  Week，它的对象只有7个：Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
 *  季节 Season，它的对象只有4个：Spring,Summer,Fall,Winter
 *  OA系统，办公系统，员工的状态Status，有几种：忙Busy，闲Free，假Vocation，离职Left
 *  支付系统，支付方式Payment，有几种：Alipay，Wechat，card， cash
 *  。。。。。
 *
 *  讨论：JDK1.5之前，如果想要实现枚举的这种效果
 *  （1）构造器私有化：
 *  	目的：在这个类的外面，无法随意的创建对象
 *  （2）在这个类中，提前创建好几个对象，供别人使用
 *
 *  JDK1.5之后，就优化了枚举的语法：
 *  构造器私有化
 * 目的  在这个类的外面 无法随意的创建对象
 * 在这个类中  提前创建好几个对象 供别人使用
 */
public class TestEnum {
    public static void main(String[] args) {
//		Gender g1 = new Gender();

        Gender nan1 = Gender.NAN;
        Gender nan2 = Gender.NAN;
        System.out.println(nan1);//com.awen.test07.Gender@1b6d3586
        System.out.println(nan2);//com.awen.test07.Gender@1b6d3586
        System.out.println(nan1 == nan2);//true
    }
}
class Gender{
    //public：使得外面可以直接访问
    //static：使得可以使用“类名.”访问
    //final：前调这个对象是不可变
    public static final Gender NAN = new Gender("男");
    public static final Gender NV = new Gender("女");
    public static final Gender YAO = new Gender("妖");

    private String description;

    private Gender(String description){
        this.description = description;
    }
}
