package com.atguigu.optional;

import java.util.Optional;

import org.junit.Test;

public class ManTest {
	
	@Test
	public void testGetGirlName2(){
		String girlName = getGirlName2(new Man(new Girl("林志玲")));
		girlName = getGirlName2(new Man());
		System.out.println(girlName);
	}
	//过程三：使用Optional类实现
	public String getGirlName2(Man man){
		Optional<Man> op = Optional.ofNullable(man);
		Man man1 = op.orElse(new Man(new Girl("苍老师")));//man1一定是非空的
		
		Girl girl = man1.getGirl();
		Optional<Girl> op1 = Optional.ofNullable(girl);
		Girl girl1 = op1.orElse(new Girl("刘亦菲"));//girl1一定非空的
		
		return girl1.getName();
	}
	
	@Test
	public void testGetGirlName1(){
		String girlName = getGirlName1(new Man(new Girl("林志玲")));
		girlName = getGirlName1(new Man());
		System.out.println(girlName);
	}
	
	//过程二：迭代
	public String getGirlName1(Man man){
		if(man != null){
			Girl girl = man.getGirl();
			if(girl != null){
				return girl.getName();
			}
		}
		
		return null;

	}
	
	@Test
	public void testGetGirlName(){
		String girlName = getGirlName(new Man(new Girl("林志玲")));
		girlName = getGirlName(new Man());
		System.out.println(girlName);
	}
	//过程一：
	public String getGirlName(Man man){
		return man.getGirl().getName();
	}
	
}	
