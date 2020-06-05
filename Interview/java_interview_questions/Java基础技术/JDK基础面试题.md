# JDK基础面试题

#### 问：String是最基本的数据类型吗?
**参考答案：**<br />　　不是，Java基本数据类型只有8种，byte、int、char、long、float、double、boolean和short。					

#### 问：Collection 和 Collections的区别？
**参考答案：**<br />

​	 	Collection是集合类的上级接口，继承与他的接口主要有Set 和List.<br />
　  	Collections是针对集合类的一个帮助类，他提供一系列静态方法实现对各种集合的搜索、排序、线程安全化等操作。<br />


#### 问：String对象的intern()是指什么?
**参考答案：**<br />		intern()方法会首先从常量池中查找是否存在该常量值,如果常量池中不存在则现在常量池中创建,如果已经存在则直接返回. 比如 String s1="aa"; String s2=s1.intern(); System.out.print(s1==s2);//返回true

#### 问：final、finally、finalize的区别是什么？
**参考答案：**<br />　	final 用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。<br />		finally是异常处理语句结构的一部分，表示总是执行。<br />		finalize是Object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收，例如关闭文件等。<br />

#### 问：error和exception有什么区别?
**参考答案：**<br />　　error通常表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出、不可能指望程序能处理这样的情况；<br />		exception通常表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况；

#### 问：运行时异常与受检异常有何异同？
**参考答案：**<br />运行时异常表示虚拟机的通常操作中可能遇到的异常，是一种常见运行错误，只要程序设计得没有问题通常就不会发生；<br />受检异常跟程序运行的上下文环境有关，即使程序设计无误，仍然可能因使用的问题而引发。Java编译器要求方法必须声明抛出可能发生的受检异常，但是并不要求必须声明抛出未被捕获的运行时异常。



#### 问：列出一些你常见的运行时异常？
**参考答案：**

- ArithmeticException（算术异常）<br />

- ClassCastException （类转换异常）<br />

- IllegalArgumentException （非法参数异常）<br />

- IndexOutOfBoundsException （下标越界异常）<br />

- NullPointerException （空指针异常）<br />

- SecurityException （安全异常）

  
#### 问：static都有哪些用法?
**参考答案：**

- 静态变量
- 静态方法
- 静态块，多用于初始化
- 静态内部类.
- 静态导向，即import static.import static是在JDK 1.5之后引入的新特性,可以用来指定导入某个类中的静态资源,并且不需要使用类名.资源名,可以直接使用资源名,比如:

import static java.lang.Math.sin;<br />public class Test{<br />    public static void main(String[] args){<br />        //System.out.println(Math.sin(20));传统做法<br />        System.out.println(sin(20)); // 静态导包<br />    }<br />}

#### 问：final有哪些用法
**参考答案：**

1. 被final修饰的类不可以被继承
1. 被final修饰的方法不可以被重写
1. 被final修饰的变量不可以被改变.如果修饰引用,那么表示引用不可变,引用指向的内容可变.
1. 被final修饰的方法,JVM会尝试将其内联,以提高运行效率
1. 被final修饰的常量,在编译阶段会存入常量池中.