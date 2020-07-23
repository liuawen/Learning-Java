package com.awen.test04;

/*
 * java.lang.Object类型的方法：
 * （1）public String toString()
 * 		用于返回对象的信息，类似于我们原来写的getInfo()，建议所有子类重写。
 *		如果没有重写：返回的字符串由类名（对象是该类的一个实例）、at 标记符“@”和此对象哈希码的无符号十六进制表示组成。
 *
 *	如果你直接打印一个对象，或者用对象与字符串进行拼接，默认情况下会自动调用这个对象的toString()
 *  如何重写？ Alt + Shift  + S  选择Generate toString。。。。
 */
public class TestMethod {
	public static void main(String[] args) {
		Employee emp = new Employee("杨洪强", 24, 25000);
		System.out.println(emp.toString());
		//com.atguigu.test04.Employee@15db9742
		System.out.println(emp.hashCode());//366712642（十进制）--》十六进制15db9742
		
		System.out.println(emp);
		//com.atguigu.test04.Employee@15db9742  重写之前打印的
		//Employee [name=杨洪强, age=24, salary=25000.0]重写后打印
	}
}
class Employee{
	private String name;
	private int age;
	private double salary;
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
}