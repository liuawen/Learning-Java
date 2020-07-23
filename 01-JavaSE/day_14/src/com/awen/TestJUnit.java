package com.awen;

/**
 * @author Liu Awen Email:willowawen@gmail.com
 * @create 2020-05-19
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * JUnit4：
 *
 * @Test:
 * 	 用它标记的方法，就可以作为一个独立单元进行测试
 * 	如果某个类中，有多个@Test标记的方法，那么如果没有选择运行哪一个，就都会运行，如果选择了，就运行其中一个
 *
 * @Before：在xx之前
 * 		会在每一个@Test方法之前
 * @After：在xx之后
 * 		会在每一个@Test方法之后
 *
 * 要求：
 * (1)单元测试的方法都必须是public
 * (2)必须是无参的()
 * (3)必须是void
 *
 * @BeforeClass：
 * 		会在类初始化阶段完成
 * @AfterClass
 * 		会在类卸载阶段完成
 * 每个类只执行一次
 * @BeforeClass和@AfterClass而且要求方法是静态的
 */
public class TestJUnit {

/*	@Test
	void method(){
		System.out.println("非public的方法");
	}*/

/*	@Test
	public void method(String str){
		System.out.println("有参的method");
	}*/

    public void method(String str){
        System.out.println("有参的method" + str);
    }

    @Test
    public void testMethod(){
        method("hello");
    }

/*	@Test
	public String getStr(){
		return "hello";
	}*/

    @Test
    public void test1(){
        System.out.println("hello junit1");
    }

    @Test
    public void test2(){
        System.out.println("hello junit2");
    }

    @Before
    public void init(){
        System.out.println("开始....");
    }

    @After
    public void close(){
        System.out.println("结束....");
    }

    @BeforeClass
    public static void clinit(){
        System.out.println("最开始....");
    }

    @AfterClass
    public static void destroy(){
        System.out.println("最后....");
    }
}
