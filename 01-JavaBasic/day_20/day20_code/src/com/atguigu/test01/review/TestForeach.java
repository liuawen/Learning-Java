package com.atguigu.test01.review;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 用foreach遍历时，进行删除，可能保错，也可能不保错，会导致结果不确定，所以不要用foreach去删除。
 * 因为使用foreach删除时，调用的是集合的remove方法，遍历调用的是Iterator的遍历方法，那么就导致结果不一致。集合为了避免这种错误，设计
 * java.util.ConcurrentModificationException异常，有的时候可能不报异常，那么我们最后避免使用foreach删除。
 */
public class TestForeach {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		Collection c = new ArrayList();
		
		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		for (Object object : c) {
			String str = (String) object;
			if("王五".equals(str)){
				c.remove(object);
			}
		}
		System.out.println(c);
	}
}
