package com.atguigu.newinterface;
/*
 * 1.jdk 8 可以额外定义静态方法和默认方法 (静态方法和默认都有方法体)
 * 
 * 2.接口和抽象类的区别？
 *    ①分别说出二者的定义：用什么定义，内部有什么
 *    ②共同点：不能实例化；多态的方式使用
 *    ③不同点：单继承，多实现
 * 
 */
public class SubClass extends SuperClass implements CompareA,CompareB{
	
	public static void main(String[] args) {
		SubClass s = new SubClass();
		s.method();
		
		System.out.println();
		
		s.myMethod();
	}
	
	public void method(){
		
//		this.method1();
//		SubClass.method1();
		//知识点1：接口中定义的静态方法，只能由接口自身调用
		CompareA.method1();
		//知识点2：接口中定义的默认方法，可以被实现类的对象调用
		//知识点3：如果父类和接口中定义了同名同参数的方法，对于子类来说，默认执行的是父类中的方法。---类优先原则
		this.method2();
		//知识点4：如果实现类实现了多个接口，而多个接口中定义了同名同参数的默认方法，则会出现接口冲突。
		//要想解决冲突，实现类必须重写这个同名同参数的方法。调用时，执行的是自己重写的方法
		this.method3();
	}
	
	public void method3(){
		System.out.println("SubClass:深圳");
	}
	
	public void myMethod(){
		this.method3();
		super.method2();
		//在实现类中，调用接口中被重写的方法，使用如下的方式
		CompareB.super.method3();
	}

}
