package com.awen.test03;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-19
 */

import org.junit.Test;

/*
 * 1、为什么要有包装类？（了解）
 * 因为Java是面向对象的编程语言。
 * 但是Java发明时，是C语言盛行的时候，而且C语言确实很好用。特别是其中的8种基本数据类型，不管在存储还是运算都很强大。
 * 那么，Java就延续使用了C语言的8种基本数据类型。
 *
 * 存储 运算
 * 为了对象而生
 *
 * 8种基本数据类型不属于对象。
 * Java后面在设计很多的API、新的特性（泛型等），不支持基本数据类型，只支持对象。
 * Java就想了一个办法解决：为8种基本数据类型配上包装类。
 *  为对象而设计
 *
 * 2、包装类有哪些？
 * 基本		  包装类(java.lang)
 * byte  -->  Byte
 * short -->  Short
 * int 	 -->  Integer
 * long  -->  Long
 * float -->  Float
 * double --> Double
 * char   --> Character
 * boolean --> Boolean
 *
 * 3、装箱与拆箱
 * 装箱：把基本数据类型的数据  包装  称为包装类的对象
 * 		基本数据类型 -->包装类的对象
 * 拆箱：把包装类的对象  拆解  称为基本数据类型的数据
 * 		包装类的对象 -->基本数据类型
 * 装箱
 * JDK让程序员更简洁的去操作包装类，在JDK1.5引入了自动装箱与自动拆箱。在这个之前需要手动装箱与拆箱。
 * 自动装箱：当把基本数据类型的值，赋值给包装类的变量时，就会自动装箱。
 * 		注意：自动装箱与拆箱都是只发生在对应类型上。
 * 自动拆箱：把包装类的对象赋值给对应的基本数据类型的变量时，就会自动拆箱
 * 		注意：自动装箱与拆箱都是只发生在对应类型上。
 *int  Integer
 * 自动装箱  自动拆箱  都是只发生在对应类型上
 * 4、包装类的API
 * 以Integer为例
 * （1）把字符串转为int等基本数据类型的值
 * ①Integer.parseInt(xx)
 * ②Integer.valueOf(xx)
 *
 * int a = Integer.parseInt("123");
 * double d = Double.parseDouble("123.05");
 * ...
 *
 * （2）进制转换
 * 		System.out.println(Integer.toBinaryString(10));//转为二进制
		System.out.println(Integer.toOctalString(10));//转为八进制
		System.out.println(Integer.toHexString(10));//转为十六进制
 *
 *  （3）常量值
 *  MAX_VALUE
 *  MIN_VALUE
 *
 *  （4）转大小写：Character
 *  Character.toUpperCase('a')
 *  Character.toLowerCase('T')
 *
 * 5、包装类对象的缓存问题
 *  自动装箱这种情况。
 *  Byte，Short，Integer，Long：都有缓存对象   -128~127
 *  Float，Double没有缓存对象
 *  Character：0~127   最早的ASCII码表的128个字符
 *  Boolean：false,true
 */
public class TestWrapper {
    @Test
    public void test17(){
        int a = Integer.parseInt("1314");
        System.out.println(a);//1314
        double d = Double.parseDouble("123.456");
        System.out.println(d);//123.456
        boolean b = Boolean.parseBoolean("true");
        System.out.println(b);//true
    }
    @Test
    public void test16(){
        Character c1 = '0';//ASCII码，Unicode码：48
        Character c2 = '0';
        System.out.println(c1 == c2);//true

        //Character：0~127   最早的ASCII码表的128个字符
        Character c3 = '菜';
        Character c4 = '菜';
        System.out.println(c3 == c4);//false
    }

    @Test
    public void test15(){
        Double d1 = 1.0;
        Double d2 = 1.0;
        System.out.println(d1 == d2);//false
    }

    @Test
    public void test14(){
        Integer a = 1;
        Double b = 1.0;
        Long c = 1L;
        long d = 1L;

//		System.out.println(a == b);//无法比较，因为对象比较地址，必须是同一种类型或有父子类关系
//		System.out.println(a == c);//无法比较，因为对象比较地址，必须是同一种类型或有父子类关系

        System.out.println(a == d);//true //因为d是基本数据类型，a才会自动拆箱
    }

    @Test
    public void test13(){
        //自动装箱
        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b);//true    a == b比较的也是地址值     a和b指向的是同一个缓存的常量对象


        Integer c = 130;
        Integer d = 130;
        System.out.println(c == d);//false  c == d比较的也是地址值    c和d都是在堆中新建的Integer对象
    }

    @Test
    public void test12(){
        int a = 1;
        int b = 1;
        System.out.println(a == b);//true

        int c = 130;
        int d = 130;
        System.out.println(c == d);//true
    }

    @Test
    public void test11(){
        System.out.println(Character.toUpperCase('a'));//A
        System.out.println(Character.toLowerCase('T'));//t
    }

    @Test
    public void test10(){
        System.out.println(Byte.MAX_VALUE);//127
        System.out.println(Byte.MIN_VALUE);//-128

        System.out.println(Integer.MAX_VALUE);//2147483647
        System.out.println(Integer.MIN_VALUE);//-2147483648

        System.out.println(Long.MAX_VALUE);//9223372036854775807
        System.out.println(Long.MIN_VALUE);//-9223372036854775808

        System.out.println(Double.MAX_VALUE);//1.7976931348623157E308
        System.out.println(Double.MIN_VALUE);//4.9E-324

    }

    @Test
    public void test9(){
        System.out.println(Integer.toBinaryString(10));//转为二进制
        //1010
        System.out.println(Integer.toOctalString(10));//转为八进制
        //12
        System.out.println(Integer.toHexString(10));//转为十六进制
        //a
    }

    @Test
    public void test8(){
        int num1 = Integer.valueOf("123");//两边，先转成Integer对象，后拆箱为int

        double d = Double.valueOf("125.05");
    }

    @Test
    public void test7(){
        //Integer
        int num1 = Integer.parseInt("123");//把字符串类型的"123"转为int类型
        System.out.println(num1);//123

//		int num2 = Integer.parseInt("123.05");//错误，报NumberFormatException
//		System.out.println(num2);
        //Double
        double num2 = Double.parseDouble("123.05");
        System.out.println(num2);//123.05
    }

    @Test
    public void test6(){
        Integer i = new Integer(1);
        double j = 1.0;

        System.out.println(i == j);//（1）先把i拆箱为int值（2）然后把i自动类型转换为double（3）然后比较
        //一旦变为基本数据类型，那么就要考虑基本数据类型的自动类型转换或强制类型转换的问题了。
        //自动类型转换 包装类拆箱
    }


    @Test
    public void test5(){
        Integer i = new Integer(1);
        int j = 1;

        System.out.println(i == j);//（1）先把i拆箱为int值（2）然后int与int比较
    }

    @Test
    public void test4(){
        Integer i = new Integer(10);

        int a = i.intValue();//手动拆箱
        int b = i;//自动拆箱
    }

    @Test
    public void test3(){
        int a = 10;
//		Double d = a;//因为Double不是int的包装类，
//		Double d = 10;//因为Double不是int的包装类，
        Double d = 10.0;//Double包装类只能与double类型的数据自动装与拆
    }

    @Test
    public void test2(){
        //装箱操作
        int a = 10;//a是基本数据类型
        Integer aObj = a;//左边是包装类型，右边是int类型    自动装箱
        System.out.println(aObj.getClass());
    }

    @Test
    public void test1(){
        //装箱操作
        int a = 10;//a是基本数据类型
        Integer aObj = new Integer(a);//把a中的数据，包装成一个对象

        System.out.println(a);
        System.out.println(aObj);//自动调用toString(),Integer重写了Object的toString，打印的是包装的值

        System.out.println(aObj.getClass());//运行时类型
        System.out.println(aObj.hashCode());
        //Result
        //10
        //10
        //class java.lang.Integer
        //10
    }
}
