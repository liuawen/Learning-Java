package com.atguigu.test07;

import java.util.HashMap;

import org.junit.Test;

/*
 * 一、JDK1.6的HashMap：数组+链表
 * （1）new HashMap()
 * table数组初始化为了一个长度为16的空数组，threshold=12
    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;//0.75
        threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);//12
        table = new Entry[DEFAULT_INITIAL_CAPACITY];//16
    }
 * 
 * 二、几个常量与变量的介绍
 * 1、DEFAULT_INITIAL_CAPACITY：16
 * 2、DEFAULT_LOAD_FACTOR：0.75		默认加载因子
 * 3、threshold：阈值/临界值       数组需要考虑扩容的阈值	
 * 		threshold = capacity（容量，数组的长度） * load factor（加载因子，默认是0.75）
 * 		例如：	 threshold = 16 * 0.75  当数组大概3/4满的时候就考虑扩容
 *  思考：load factor设置为0.9和0.1有什么区别？
 *  	0.1：扩容太频繁
 *  	0.9：会导致table[index]下面的链表会很长，查询速度就低
 * 
 * 三、JDK1.7的HashMap：数组+链表
 * 1、new HashMap()
 * table数组初始化为了一个长度为0的空数组
 *  
 * 2、 put()
 * 步骤：
 * （1）发现数组table是空数组后，会把数组初始化为长度为16的Entry类型的数组，并且把threshold计算为12
 * 这里如果你手动指定了数组的capacity，那么如果这个capacity不是2的n次方，会自动纠正为2的n次方
 * 
 * 为什么要纠正为2的次方？
 * ①后面算index = hash & table.length-1，这样才能保证[0,table.length-1]范围内
 * ②2的次方，根据它的散列算法，可以保证比较均匀的分散在它的数组的各个位置
 * 
 * （2）如果key是null，特殊对待，key为null的映射关系的hash值为0,index也为0
 * 
 * （3）hash = hash(key) 
 * 为了干扰我们key的hashCode值
 * 
 * （4）index = hash & table.length-1
 * （5）先判断table[index]下面是否有映射关系的key是和我新添加的映射关系的key有重复的，如果有，就用新的value替换旧的value，就结束了
 * （6）如果没有重复的，决定添加新的映射关系
 * ①看是否需要扩容
 * 扩容的条件：A：size达到阈值threshold  B：table[index]下面已经有映射关系，即不为空
 * 如果扩容了，会重新计算hash和index
 * 
 * ②把新的映射关系new为一个Entry的对象，放到table[index]中，原来table[index]的映射关系作为新的映射关系的next连接起来。
 * 
 * Entry相当于是一个结点类型。是一个单向链表的结点类型。
 * class Entry{
 * 		int hash;
 * 	    Object key;
 * 		Object value;
 * 		Entry next;
 * }
 * 
 */
@SuppressWarnings("all")
public class TestHashMap7 {
	@Test
	public void test(){
		HashMap map = new HashMap();
		
		map.put(null, "aa");
		map.put("Aa", "bb");
		map.put("BB", "bb");
		map.put("A", "xx");
		map.put("B", "xx");
		
		for (int i = 0; i < 15; i++) {
			map.put(i+"", "xx");
		}
	}
	
	@Test
	public void test2(){
		System.out.println("Aa".hashCode());//2112
		System.out.println("BB".hashCode());//2112
	}
}

