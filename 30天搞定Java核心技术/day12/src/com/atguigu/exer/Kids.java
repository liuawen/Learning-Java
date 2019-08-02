package com.atguigu.exer;
/*
 * 定义类Kids继承ManKind，并包括
成员变量int yearsOld；
方法printAge()打印yearsOld的值。

 */
public class Kids extends ManKind{
	private int yearsOld;
	
	public Kids() {
	}

	public Kids(int yearsOld) {
		this.yearsOld = yearsOld;
	}

	public void printAge(){
		System.out.println("I am " + yearsOld + " years old.");
		
	}

	public int getYearsOld() {
		return yearsOld;
	}

	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}
	/*
	 * 修改练习1.2中定义的类Kids，在Kids中重新定义employeed()方法，
	 * 覆盖父类ManKind中定义的employeed()方法，
	 * 输出“Kids should study and no job.”
	 */
	
	public void employeed() {
		System.out.println("Kids should study and no job.");
	}
}
