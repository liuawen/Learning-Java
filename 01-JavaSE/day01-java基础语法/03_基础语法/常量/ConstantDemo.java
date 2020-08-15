/*
	常量：
		在程序运行过程中，其值不可以发生改变的量。

	常量分类：
		字符串常量：	用双引号括起来的内容。"HelloWorld","黑马程序员"
		整数常量：		不带小数的数字。666,-88
		小数常量：		带小数的数字。13.14,-5.21
		字符常量：		用单引号括起来的内容。'A','0','我'
		布尔常量：		布尔值，表示真假。true,false
		空常量：		一个特殊的值，空值。null
*/
public class ConstantDemo {
	public static void main(String[] args) {
		//字符串常量
		System.out.println("HelloWorld");
		System.out.println("黑马程序员");
		System.out.println("--------");
		
		
		//整数常量
		System.out.println(666);
		System.out.println(-88);
		System.out.println("--------");
		
		//小数常量
		System.out.println(13.14);
		System.out.println(-5.21);
		System.out.println("--------");
		
		//字符常量
		System.out.println('A');
		System.out.println('0');
		System.out.println('我');
		System.out.println("--------");
		
		//布尔常量
		System.out.println(true);
		System.out.println(false);
		System.out.println("--------");
		
		//空常量
		//空常量是不能直接输出的
		//System.out.println(null);
	}
}