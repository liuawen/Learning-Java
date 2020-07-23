package cn.itcast.demo8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
/*
 * 已知 创建一个类并得知它的路径 是cn.itcast.demo8.User
 *  
 *  根据该路径 获取到  User类的字节码文件对象
 *  根据字节码对象 获取 其 的 空参构造
 *  根据空参构造的newInstance方法 通过反射方式创建对象
 *  
 *  在根据反射获取该
 */
public class MainApp {
	public static void main(String[] args) throws Exception {
		 //获取到  User类的字节码文件对象
		Class clazz = Class.forName("cn.itcast.demo8.User");
	   //根据字节码文件对象获取空参构造
		Constructor cons = clazz.getConstructor();
		//根据反射获取对象
		Object obj = cons.newInstance();
		
		//根据反射获取该方法 
		Method method = clazz.getMethod("show");
		
		method.invoke(obj);
	}
}
