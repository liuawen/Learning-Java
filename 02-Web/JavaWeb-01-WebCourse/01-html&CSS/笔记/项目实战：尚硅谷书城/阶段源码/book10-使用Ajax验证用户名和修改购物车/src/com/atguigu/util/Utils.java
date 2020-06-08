package com.atguigu.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 工具类
 * 
 * @author wzg
 *
 */
public class Utils {
	private Utils() {
	}

	// 把map集合中的值，赋值到Object对象中
	public static void copyMap2Bean(Map<String, String[]> value, Object Object) {

		try {
			// 把map中的值注入到object对象中
			BeanUtils.populate(Object, value);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	public static int parseInt(String intStr, int defaultValue) {
		int id = 0;
		try {
			id = Integer.parseInt(intStr);
		} catch (Exception e) {
//			e.printStackTrace();
			return defaultValue;
		}
		return id;
	}
	
	public static long parseLong(String longStr, long defaultValue) {
		long value = 0;
		try {
			value = Long.parseLong(longStr);
		} catch (Exception e) {
//			e.printStackTrace();
			return defaultValue;
		}
		return value;
	}

	public static double parseDouble(String doubleStr, double defaultValue) {
		double value = 0;
		try {
			value = Double.parseDouble(doubleStr);
		} catch (Exception e) {
//			e.printStackTrace();
			return defaultValue;
		}
		return value;
	}

}
