package com.atguigu.test03;

import java.util.Vector;

import org.junit.Test;

/*
 * Vector源码跟踪：
 * （1）new Vector()：初始化长度为10的数组，默认增量是0
 * （2）add(E e)：
 * 默认扩容为原来的2倍
 * 如果你手动指定了capacityIncrement的值，那么可以按照你指定增量进行扩容。
 * （3）add(index,e)：
 * ①考虑扩容
 * ②移动元素
 * ③添加元素
 * ④元素个数增加
 * （4）remove(index)：
 * ①计算要移动元素的个数
 * ②如果需要移动，调用System.arraycopy方法进行移动
 * ③elementData[--elementCount] = null;
 * （5）remove(Object obj)
 * ①查找obj的下标
 * ②如果不是-1就调用remove(index)进行删除
 * （6）indexOf(Object obj)
 * 对obj分情况讨论：（1）是null（2）不是null
 */
public class TestVector {
	@Test
	public void test1(){
		Vector v = new Vector();
		
		v.add("1");
		v.add(0, "2");//[0]
		
		v.remove(1);
		
		v.remove("1");
		
		int index = v.indexOf("1");
	}
}
