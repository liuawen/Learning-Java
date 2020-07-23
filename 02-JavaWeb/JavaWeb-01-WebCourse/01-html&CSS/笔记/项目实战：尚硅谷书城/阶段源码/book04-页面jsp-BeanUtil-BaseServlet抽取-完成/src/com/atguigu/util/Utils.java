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
	public static void copyParameter2Bean(Map<String, String[]> value, Object Object) {

		try {
			// 把map中的值注入到object对象中
			BeanUtils.populate(Object, value);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
