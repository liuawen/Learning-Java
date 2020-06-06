package cn.itcast.demo;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MainApp {
	public static void main(String[] args) throws Exception {
		 
		   //创建一个集合对象
		   ArrayList<Integer> list = new ArrayList<Integer>();
		   
		   //存储
		   list.add(12);
		   list.add(new Integer(110));
		   
//		   list.add("abc");
		   //获取字节码文件对象
		   Class clazz = list.getClass();
		   
		   //获取  add方法
		  Method method =  clazz.getMethod("add", Object.class);
		   
		  method.invoke(list, "abc");
	
		  
		  
		  System.out.println(list);
	   }
}
