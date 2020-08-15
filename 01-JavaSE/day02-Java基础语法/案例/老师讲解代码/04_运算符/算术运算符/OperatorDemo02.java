/*
	字符的"+"操作
*/
public class OperatorDemo02 {
	public static void main(String[] args) {
		//定义两个变量
		int i = 10;
		char c = 'A'; //'A'的值是65
		c = 'a'; //'a'的值是97
		c = '0'; //'0'的值是48
		System.out.println(i + c);
		
		//char ch = i + c;
		//char类型会被自动提升为int类型
		int j = i + c;
		System.out.println(j);
		
		//int k = 10 + 13.14;
		double d = 10 + 13.14;
	}
}