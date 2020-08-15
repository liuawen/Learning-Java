/*
	变量使用的注意事项：
		名字不能重复
		变量未赋值，不能使用
		long类型的变量定义的时候，为了防止整数过大，后面要加L
		float类型的变量定义的时候，为了防止类型不兼容，后面要加F
*/
public class VariableDemo02 {
	public static void main(String[] args) {
		//定义byte类型的变量
		byte b = 10;
		System.out.println(b);
		
		//定义short类型的变量
		short s = 100;
		System.out.println(s);
		
		//定义int类型的变量
		int i = 10000;
		System.out.println(i);
		
		//定义double类型的变量
		double d = 13.14;
		System.out.println(d);
		
		//定义char类型的变量
		char c = 'a';
		System.out.println(c);
		
		//定义boolean类型的变量
		//boolean b = true;
		//System.out.println(b);
		boolean bb = true;
		System.out.println(bb);
		System.out.println("--------");
		
		//定义long类型的变量
		long l = 10000000000L;
		System.out.println(l);
		System.out.println("--------");
		
		//定义float类型的变量
		float f = 13.14F;
		System.out.println(f);
	}	
}









