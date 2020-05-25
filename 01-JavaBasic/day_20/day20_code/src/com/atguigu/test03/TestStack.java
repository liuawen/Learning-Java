package com.atguigu.test03;

import java.util.Stack;

/*
 * Stack：栈   源码分析
 * 
 * （1）peek
 * 返回size-1位置的元素
 * （2）pop
 * ①先peek()返回栈顶元素
 * ②删除size-1位置的元素
 * （3）push：等价于add
 * 把元素添加到[size++]位置
 */
public class TestStack {
	public static void main(String[] args) {
		Stack s  = new Stack();
		s.push(1);
		s.peek();
		s.pop();
	}
}
