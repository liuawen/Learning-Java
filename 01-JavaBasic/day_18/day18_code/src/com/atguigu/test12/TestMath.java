package com.atguigu.test12;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

/*
 * 数学相关的常用类：
 * 1、java.lang.Math类
 * 
 * 2、java.math包
 * BigInteger
 * BigDecimal
 * 
 * 
 * 面试题：int ,Integer, BigInteger什么区别？
 */
public class TestMath {
	@Test
	public void test4(){
		BigDecimal big1 = new BigDecimal("72.345678912345678912345678");
		BigDecimal big2 = new BigDecimal("4.2345678912345678912345678");
		
		System.out.println("和：" + big1.add(big2));
		System.out.println("减：" + big1.subtract(big2));
		System.out.println("乘：" + big1.multiply(big2));
//		System.out.println("除：" + big1.divide(big2));//如果除不尽，会报异常
		
		//divide(BigDecimal divisor, int scale, int roundingMode)
		System.out.println("除：" + big1.divide(big2, 10, BigDecimal.ROUND_CEILING));
		System.out.println("余：" + big1.remainder(big2));
	}
	
	@Test
	public void test3(){
//		long big = 12345678912345678912345678L;
		BigInteger big1 = new BigInteger("72345678912345678912345678");
		BigInteger big2 = new BigInteger("42345678912345678912345678");
		
		System.out.println("和：" + big1.add(big2));
		System.out.println("减：" + big1.subtract(big2));
		System.out.println("乘：" + big1.multiply(big2));
		System.out.println("除：" + big1.divide(big2));
		System.out.println("余：" + big1.remainder(big2));
	}
	
	
	@Test
	public void test2(){
		System.out.println(Math.ceil(2.1));//进一法
		System.out.println(Math.floor(2.1));//退一法
		System.out.println(Math.round(2.1));//四舍五入
		System.out.println();
		
		System.out.println(Math.ceil(2.6));//进一法
		System.out.println(Math.floor(2.6));//退一法
		System.out.println(Math.round(2.6));//四舍五入
		System.out.println();
		
		System.out.println(Math.ceil(-2.1));//进一法
		System.out.println(Math.floor(-2.1));//退一法
		System.out.println(Math.round(-2.1));//四舍五入
		System.out.println();
		
		System.out.println(Math.ceil(-2.6));//进一法
		System.out.println(Math.floor(-2.6));//退一法
		System.out.println(Math.round(-2.6));//四舍五入
		System.out.println();
	}
	
	@Test
	public void test1(){
		System.out.println(Math.PI);
		System.out.println(Math.sqrt(9));
		System.out.println(Math.pow(2, 8));//2的8次方
		System.out.println(Math.max(5, 9));
		System.out.println(Math.min(3, 9));
	}
}
