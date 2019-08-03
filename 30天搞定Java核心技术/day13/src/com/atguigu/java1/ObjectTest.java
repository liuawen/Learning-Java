package com.atguigu.java1;
/*
 * java.lang.Object类
 * 1.Object类是所有Java类的根父类
 * 2.如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object类 
 * 3.Object类中的功能(属性、方法)就具有通用性。
 * 	属性：无
 *  方法：equals() / toString() / getClass() /hashCode() / clone() / finalize()
 *     wait() 、 notify()、notifyAll()
 * 
 * 4. Object类只声明了一个空参的构造器
 * 
 * 
 * 
 * 面试题：
 * final、finally、finalize的区别？
 * 
 */
public class ObjectTest {

	public static void main(String[] args) {
		
		Order order = new Order();
		System.out.println(order.getClass().getSuperclass());
		
	}
}

class Order{
	
}