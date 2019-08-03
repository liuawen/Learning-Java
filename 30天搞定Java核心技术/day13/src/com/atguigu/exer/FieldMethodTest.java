package com.atguigu.exer;
/*
 * 练习：
 * 1.若子类重写了父类方法，就意味着子类里定义的方法彻底覆盖了父类里的同名方法，
 * 系统将不可能把父类里的方法转移到子类中：编译看左边，运行看右边
 * 
 * 2.对于实例变量则不存在这样的现象，即使子类里定义了与父类完全相同的实例变量，
 * 这个实例变量依然不可能覆盖父类中定义的实例变量：编译运行都看左边
 * 
 * 
 * 
 * 
 */
class Base {
	int count = 10;

	public void display() {
		System.out.println(this.count);
	}
}

class Sub extends Base {
	int count = 20;

	public void display() {
		System.out.println(this.count);
	}
}

public class FieldMethodTest {
	public static void main(String[] args) {
		Sub s = new Sub();
		System.out.println(s.count);//20
		s.display();//20
		
		Base b = s;//多态性
		//==：对于引用数据类型来讲，比较的是两个引用数据类型变量的地址值是否相同
		System.out.println(b == s);//true
		System.out.println(b.count);//10
		b.display();//20
	}
}
