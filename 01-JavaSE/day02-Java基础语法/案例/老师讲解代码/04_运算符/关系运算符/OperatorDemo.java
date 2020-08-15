/*
	关系运算符
*/
public class OperatorDemo {
	public static void main(String[] args) {
		//定义变量
		int i = 10;
		int j = 20;
		int k = 10;
		
		//==
		System.out.println(i == j);
		System.out.println(i == k);
		System.out.println("--------");
		
		//!=
		System.out.println(i != j);
		System.out.println(i != k);
		System.out.println("--------");

		//>
		System.out.println(i > j);
		System.out.println(i > k);
		System.out.println("--------");
		
		//>=
		System.out.println(i >= j);
		System.out.println(i >= k);
		System.out.println("--------");
		
		//不小心把==写成了=
		//把j的值赋值给了i，然后输出i的值
		System.out.println(i = j);
	}
}