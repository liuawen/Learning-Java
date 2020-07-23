package cn.itcast.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
/*
 * 定义一个标准的Person类，包含属性name，包含setget方法,包含空参构造。
     使用反射的方式创建一个实例、并初始化，
      使用反射方式调用setName方法对名称进行设置,
      设置之后 在通过反射方式执行getName()方法
 */
public class MainApp {
	public static void main(String[] args) throws Exception {
		
		
		
		 //获取到  Person类的字节码文件对象
		Class clazz = Class.forName("cn.itcast.demo.Person");
	   //根据字节码文件对象获取空参构造
		//根据反射获取对象
		Object obj = clazz.newInstance();
		
		//调用setName方法对名称进行设置 
		Method method = clazz.getMethod("setName",String.class);
		
		method.invoke(obj,"小刚");
		
		//通过反射方式执行getName()方法
		Method method2 = clazz.getMethod("getName");
		System.out.println(method2.invoke(obj));
		
	}
}
