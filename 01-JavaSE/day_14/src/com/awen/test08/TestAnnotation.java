package com.awen.test08;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-19
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/*
 * 1、注解：
 * 	 也是一种注释。它是代码级别的注释。是用代码注释代码。
 *  不同于我们之前的单行注释//，多行注释/*  * /
 * 注解
 * 当你在代码中，看到@开头就是注解了。
 *
 * 2、一个完整的注解，由三部分组成：
 * （1）声明
 * （2）使用
 * （3）读取
 *
 * 绝大多数程序员，面对的基本上是（2）使用。
 * 使用
 * 3、系统中预定义的三个最基本的注解
 * （1）@Override  重写
 * 作用：检查这个方法是否符合重写的要求
 * ①方法名：相同
 * ②形参列表：相同
 * ③返回值类型
 * 	  基本数据类型和void：相同
 * 	 引用数据类型：<=
 * ④修饰符
 * 	权限修饰符：>=
 * 	其他修饰符：private,static,final不能重写
 *
 * （2）@SuppressWarnings(xx)
 * 作用：抑制警告
 *
 * （3）@Deprecated
 * 作用：标记某个方法、类、属性等已过时
 * 不建议程序员继续使用，因为可能有问题，也可能是不好用。
 *
 * 面向对象的开发原则：对修改关闭，对扩展开发
 */
public class TestAnnotation {
    //	@SuppressWarnings({ "unchecked", "rawtypes" })
    @SuppressWarnings("all")
    public static void main(String[] args) {
        String[] all = {"hello","Hai","Java","chai"};
        Arrays.sort(all, new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
                String s1 = (String) o1;
                String s2 = (String) o2;
                return s1.compareToIgnoreCase(s2);
            }

        });

/*		Arrays.sort(all, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}

		});*/

	/*	for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}*/

        Date date = new Date(2019,6,1);
        System.out.println(date);
    }
}
class Father{
    public void print1n(){
        System.out.println("父类的方法");
    }
}
class Son extends Father{
    //重写
/*	@Override
	public void println(){
		System.out.println("子类的方法");
	}*/
}