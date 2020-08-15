/*	
	赋值运算符
*/
public class OperatorDemo {
	public static void main(String[] args) {
		//把10赋值给int类型的变量i
		int i = 10;
		System.out.println("i:" + i);
		
		// += 把左边和右边的数据做加法操作，结果赋值给左边
		i += 20;
		//i = i + 20;
		System.out.println("i:" + i);
		
		//注意：扩展的赋值运算符底层隐含了强制类型转换
		short s = 10;
		s += 20;
		//s = (short)(s + 20);
		System.out.println("s:" + s);
	}
}
