package com.atguigu.test06;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

/*
 * 一、Map接口的实现类们：
 * 1、HashMap
 * 2、Hashtable
 * 3、TreeMap
 * 4、LinkedHashMap
 * 5、Properties
 * 
 * 二、HashMap和Hashtable  哈希表
 * Hashtable：旧版。线程安全的。它的key和value不能为null。
 * HashMap：相对Hashtable它来说新一点。线程不安全。它允许key和value为null值。
 * 
 * StringBuffer和StringBuilder
 * Vector和ArrayList
 * Hashtable和HashMap
 * 
 * 三、HashMap和LinkedHashMap 
 * LinkedHashMap是HashMap的子类，比HashMap多维护了映射关系的添加顺序。
 * 
 * 	HashMap：无序的。
 *  LinkedHashMap：可以记录添加顺序。
 * 
 * LinkedHashMap比HashMap要做的事多，效率低。只在需要维护顺序时再使用它。
 * 
 * 四、HashMap和TreeMap
 * HashMap：无序的。
 * TreeMap：按照key排大小顺序。
 * 
 * 五、Properties
 * Properties是Hashtable的子类，不允许key和value是null，并且它的key和value的类型都是String。
 * 通常用于存储配置属性。
 * 而且为了可读性更好，还增加了两个方法：
 * setProperty(key,value)
 * String getProperty(key)
 * 
 * 六、所有的map的key不能重复，如何实现不重复?
 * HashMap、Hashtable、LinkedHashMap、Properties：依据key的hashCode和equals方法
 * TreeMap：依据key的大小，认为大小相等的两个key就是重复的
 * 
 * 如果key重复了，那么后面的value会替换原来的value。
 * 
 * TreeMap要让key排大小，要么key类型本身实现了java.lang.Comparable接口，要么在创建TreeMap时，指定一个java.util.Comparator接口的实现类对象。
 * 
 */
@SuppressWarnings("all")
public class TestMapImpl {
	
	//key不可重复
	@Test
	public void test7(){
		Map map = new HashMap();
		
		map.put("杨洪强", "翠花");//被覆盖了
		map.put("崔志恒", "如花");
		map.put("甄玉禄", "凤姐");
		map.put("杨洪强", "冰冰");
		
		Set entrySet = map.entrySet();
		for (Object entry : entrySet) {
			System.out.println(entry);
		}
	}
	
	
	@Test
	public void test6() throws IOException{
		Properties pro = System.getProperties();//获取系统属性配置
		Set entrySet = pro.entrySet();
		for (Object entry : entrySet) {
			System.out.println(entry);
		}
	}
	
	@Test
	public void test5() throws IOException{
		Properties pro = new Properties();
		pro.load(TestMapImpl.class.getClassLoader().getResourceAsStream("jdbc.properties"));
		
		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		System.out.println(user);
		System.out.println(password);
	}
	
	@Test
	public void test4(){
		Properties pro = new Properties();
		pro.setProperty("user", "chailinyan");
		pro.setProperty("pwd", "123456");
		
		String user = pro.getProperty("user");
		String password = pro.getProperty("pwd");
		System.out.println(user);
		System.out.println(password);
	}
	
	@Test
	public void test3(){
		Map map = new TreeMap();//按照key排大小顺序。
		
		map.put("yanghongqiang", "翠花");
		map.put("cuizhiheng", "如花");
		map.put("zhenyulu", "凤姐");
		map.put("suhaibo", "翠花");
		
		Set entrySet = map.entrySet();
		for (Object entry : entrySet) {
			System.out.println(entry);
		}
	}
	
	@Test
	public void test2(){
		Map map = new LinkedHashMap();//按照添加顺序
		
		map.put("杨洪强", "翠花");
		map.put("崔志恒", "如花");
		map.put("甄玉禄", "凤姐");
		map.put("苏海波", "翠花");
		
		Set entrySet = map.entrySet();
		for (Object entry : entrySet) {
			System.out.println(entry);
		}
	}
	
	@Test
	public void test1(){
		Map map = new HashMap();//完全无序
		
		map.put("杨洪强", "翠花");
		map.put("崔志恒", "如花");
		map.put("甄玉禄", "凤姐");
		map.put("苏海波", "翠花");
		
		Set entrySet = map.entrySet();
		for (Object entry : entrySet) {
			System.out.println(entry);
		}
	}
}
