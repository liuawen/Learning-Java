package com.atguigu.test03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/*
 * 2、把本组学员的组长姓名作为key，组员的姓名作为value，多个组员用ArrayList装起来，
放到HashMap中，正确指定泛型，并且遍历

当如果出现泛型的嵌套，那么从外到内分析
 */
public class TestExer2 {
	public static void main(String[] args) {
		//HashMap<K,V>：K代表key的类型，V代表value的类型
		//组长姓名作为key，说明K是String
		//组员的姓名作为value，多个组员用ArrayList装起来,说明V是ArrayList类型
		//因为ArrayList也是泛型类，ArrayList中装的是组员的姓名，所以是String类型
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		ArrayList<String> group1 = new ArrayList<String>();
		group1.add("杨洪强");
		group1.add("苏海波");
		
		map.put("杨洪强", group1);
		
		ArrayList<String> group8 = new ArrayList<String>();
		group8.add("崔志恒");
		group8.add("甄玉禄");
		group8.add("杜冠军");
		
		map.put("崔志恒", group8);
		
		System.out.println("遍历所有的组长：");
		Set<String> keySet = map.keySet();
		for (String zuZhang : keySet) {
			System.out.println(zuZhang);
		}
		
		System.out.println("遍历所有的学员：");
		Collection<ArrayList<String>> values = map.values();
		for (ArrayList<String> group : values) {
			System.out.println(group);
		}
		
		System.out.println("遍历每一组的情况：");
		Set<Entry<String, ArrayList<String>>> entrySet = map.entrySet();
		for (Entry<String, ArrayList<String>> entry : entrySet) {
			System.out.println(entry);
		}
	}
}
