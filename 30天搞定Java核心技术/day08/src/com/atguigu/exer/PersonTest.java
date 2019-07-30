package com.atguigu.exer;
/*
 * 要求：
 * (1)创建Person类的对象，设置该对象的name、age和sex属性，调用study方法，
 * 输出字符串“studying”，调用showAge()方法显示age值，
 * 调用addAge()方法给对象的age属性值增加2岁。
 * (2)创建第二个对象，执行上述操作，体会同一个类的不同对象之间的关系。
 * 
 * 
 */
public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		
		p1.name = "Tom";
		p1.age = 18;
		p1.sex = 1;
		
		p1.study();
		
		p1.showAge();
		
		int newAge = p1.addAge(2);
		System.out.println(p1.name + "的新年龄为：" + newAge);
		
		System.out.println(p1.age);//20
		
		//*************************
		Person p2 = new Person();
		p2.showAge();//0
		p2.addAge(10);
		p2.showAge();//10
		
		p1.showAge();
		
	}
}
