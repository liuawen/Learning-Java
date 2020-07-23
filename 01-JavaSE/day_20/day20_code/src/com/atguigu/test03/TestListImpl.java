package com.atguigu.test03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

/*
 *一、 List接口的实现类们：
 * 1、Vector：动态数组
 * 	 物理结构：数组
 * 2、ArrayList：动态数组
 * 	物理结构：数组
 * 3、Stack：栈，它是Vector的子类
 * 	物理结构：数组
 * 4、LinkedList：双向链表
 * 	物理结构：链表
 * 
 * 二、Vector和ArrayList的区别？（同时也是面试题）
 * Vector：最早版本的动态数组（旧版），线程安全的（有线程同步的），不够后扩容为原来的2倍，初始容量：10，
 * 		Vector支持的遍历集合的方式有：（1）foreach（2）Iterator（3）支持旧版的Enumeration迭代器
 * ArrayList：相对Vector来说新一点（新版），线程不安全的（没有线程同步的），不够后扩容为原来的1.5倍，初始容量：10，
 * 		ArrayList支持的遍历集合的方式有：（1）foreach（2）Iterator
 * 
 * 2倍：造成空间浪费的可能性比较大
 * 1.5倍：造成扩容的次数增大
 * 
 * Vector和ArrayList的使用时，为了比较空间浪费，和扩容次数太多，如果能够预估大概的元素个数，那么可以用
 * ArrayList(int initialCapacity)和Vector(int initialCapacity)直接初始化为一定容量的数组。
 * 
 * 
 * StringBuffer和StringBuilder类似
 * 
 * 三、Stack：栈
 * 先进后出（FILO）或后进先出（LIFO：Last in first out）
 * Stack是Vector的子类，比Vector多了几个方法，它的后进先出的特征，就是通过调用这几个方法实现的。
 * (1)Object peek() ：访问当前栈顶元素，但是不拿走栈顶元素
 * (2)Object pop()：弹出栈顶元素
 * (3)Object push(Object item) ：把元素压入栈顶，等价于add(item)
 * 		这里为了更形象化，单独设计了一个push。
 * 
 * 四、LinkedList：双向链表（双向链表、队列、栈、双端队列、单向链表等各种数据结构的效果）
 * 内部有一个结点的类型：
 * class Node{
 * 	 Object data;
 *   Node previous;
 *   Node next;
 * }
 * 
 * class LinkedList{
 * 	  Node first;//记录第一个结点的地址
 * 	  Node last;//记录最后一个结点的地址
 * }
 * 空链表：if(first == null && last ==null)
 * 有一个结点：  first == last
 * 第一个结点：  first.previous = null
 * 最后一个结点：last.next == null
 * 
 * LinkedList可以被当做双向链表、栈、队列、双端队列等数据结构使用。
 * 如何体现双向链表？
 * (1)E getFirst() 
 * (2)E getLast() 
 * (3)boolean offerFirst(E e) ：添加的第一个
 * (4)boolean offerLast(E e)  :添加到最后一个
 * (5)int indexOf(Object o)  ：从first开始找
 * (6)int lastIndexOf(Object o) ：从last开始找
 * (7) E get(int index)  
 * 		先判断index是靠前还是靠后
 * 
 * 如何体现栈？
 * E peek() 
 * E pop() 
 * void push(E e) 
 * 
 * 如何体现队列？实现了Queue接口
 * 队列：先进先出（FIFO）
 *  抛出异常      	返回特殊值 
插入 add(e)     offer(e) 
移除 remove()   poll() 
检查 element()  peek() 
 * 
 * 如何体现双端队列？JDK1.6才支持，实现了Deque（double ended queue（双端队列）的缩写）
 * 下表总结了上述 12 种方法： 

 第一个元素（头部）		 			最后一个元素（尾部） 
 抛出异常 			特殊值 			抛出异常          特殊值 
插入 addFirst(e) offerFirst(e) addLast(e) offerLast(e) 
移除 removeFirst() pollFirst() removeLast() pollLast() 
检查 getFirst() peekFirst()    getLast() peekLast() 
 */
@SuppressWarnings("all")
public class TestListImpl {
	@Test
	public void test5(){
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		System.out.println(list.poll());//1
		System.out.println(list.poll());//2
		System.out.println(list.poll());//3
		System.out.println(list.poll());//4
	}
	
	@Test
	public void test4(){
		//用ArrayList，实现后进先出的效果
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		System.out.println(list.remove(list.size()-1));//4
		System.out.println(list.remove(list.size()-1));//3
		System.out.println(list.remove(list.size()-1));//2
		System.out.println(list.remove(list.size()-1));//1
	}
	
	@Test
	public void test3(){
		Stack s = new Stack();
		s.push("1");//push比add可读性更好，功能是一样的
		s.push("2");
		s.push("3");
		s.push("4");
		
		System.out.println(s.pop());//4
		System.out.println(s.pop());//3
		System.out.println(s.pop());//2
		System.out.println(s.pop());//1
	}
	
	@Test
	public void test2(){
		Stack s = new Stack();
		s.add("1");
		s.add("2");
		s.add("3");
		s.add("4");
		
		System.out.println(s.pop());//4
		System.out.println(s.pop());//3
		System.out.println(s.pop());//2
		System.out.println(s.pop());//1
//		System.out.println(s.pop());//java.util.EmptyStackException
	}
	
	@Test
	public void test1(){
		Stack s = new Stack();
		s.add("1");
		s.add("2");
		s.add("3");
		s.add("4");
		
		System.out.println(s.peek());//4
		System.out.println(s.peek());//4
		System.out.println(s.peek());//4
	}
}
