package com.awen.test04;

/*
 * java.lang.Object的方法：
 * （3）protected void finalize()：
 * 	当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器（GC）调用此方法。  即不是程序员手动调用
 * 	子类重写 finalize 方法，以配置系统资源或执行其他清除。
 * 
 *  什么情况下调用？
 *  ①某个对象确定要被回收了，比喻成“留临终遗言”
 *  ②Java程序员是否无法确定具体哪个时间点会调用
 *  ③它是由GC调用的
 *  ④每一个对象，finalize()只能被调用一次。
 *  如果某个对象在被GC回收之前复活了，那么再死的时候，就不会调用finalize()
 *  当我们在finalize()方法中又让一个引用指向了当前对象this,那么这个对象就复活。
 *  
 *  面试题：final，finalize，finally的区别？
 */
public class TestMethod3 {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 1; i <=10; i++) {
			MyClass my = new MyClass();
			//for循环体中局部变量，每一次循环，都是一个新的局部变量，my指向的对象，在一次循环之后就变为垃圾对象了
		}
		
		//通知垃圾回收器，尽快来回收
		System.gc();//但是不能保证立刻马上过来
		
		Thread.sleep(1000);//休眠，暂停1秒 =1000毫秒
	}
}
class MyClass{

	@Override
	protected void finalize() throws Throwable {
		System.out.println("轻轻的我走了，正如我轻轻的来....");
	}
	
}