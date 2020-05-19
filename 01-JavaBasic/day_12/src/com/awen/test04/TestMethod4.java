package com.awen.test04;

/*
 * java.lang.Object的方法：
 * （4）
 * public int hashCode()：返回该对象的哈希码值。支持此方法是为了提高哈希表的性能。
 * 		哈希码值是用这个对象的信息（属性值），通过某种算法，计算出来的一个int值。就好比我们身份证号码代表一个人的信息。
 * 		理想状态下，那么每一个对象都应该有一个唯一的哈希码值。
 * 	
 * 		现实中，两个不同的对象，可能它的哈希码值相同。	
 * 		认为：
 * 			如果两个对象的哈希码值不同，就可以认为这个两个对象一定不“相等”，
 * 		但是，如果两个对象的哈希码值相同，我们不能认为这个两个对象就一定“相等”，可能相同，也可能不同。
 * 
 * public boolean equals(Object obj)：指示其他某个对象是否与此对象“相等”。 
 * 		换句话说，如果最终要确定两个对象是否“相等”要依据equals方法。
 * 
 * 默认情况下，Object类中实现的equals方法，即如果我们自己写的类，没有重写equals方法的话，那么它的比较是等价于“==”，比较的是对象的“地址值”
 * 我们可以选择进行重写：
 * （1）当此方法equals被重写时，通常有必要重写 hashCode 方法
 * 为什么？
 * 因为：
 * 	 Java中规定 ①如果两个对象调用equals方法返回true，那么这两个对象的hashCode值必须相同
 * 			②如果两个对象的hashCode值不同，那么调用equals方法必须是false
 * 			③如果两个对象的hashCode值相同，那么调用equals方法可能true也可能false
 * 
 * （2）重写equals方法时，要遵循几个原则
 * ①自反性：  x.equals(x)一定true
 * ②对称性：x.equals(y) 和y.equals(x)结果一样
 * ③传递性： x.equals(y)是true,y.equals(z)也是true，那么x.equals(z)一定true
 * ④一致性：只要参与equals比较的属性值没有修改过，那么无论何时调用，结果都应该一样
 * ⑤对于任何非空引用值 x，x.equals(null) 都应返回 false
 */
public class TestMethod4 {
	public static void main(String[] args) {
/*		String s1 = "Aa";
		String s2 = "BB";
		System.out.println(s1.hashCode());//2112
		System.out.println(s2.hashCode());//2112
*/	
		Circle c1 = new Circle();
		c1.radius = 1;
		
		Circle c2 = new Circle();
		c2.radius = 1;
		
		System.out.println(c1 == c2);//false
		System.out.println(c1.equals(c2));//false（重写前） true（重写后）
		
		//回忆
		String str1 = new String("hello");
		String str2 = new String("hello");
		System.out.println(str1 == str2);//false
		System.out.println(str1.equals(str2));//true  因为String类型重写了equals方法
		
		System.out.println("----------------------------");
		String s1 = "hello";//特殊，因为s1和s2指向同一个常量对象，地址值是同一个
		String s2 = "hello";
		System.out.println(s1 == s2);//true
		System.out.println(s1.equals(s2));//true
	}
}
class Circle{
	double radius;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}
	
}
