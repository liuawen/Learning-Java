/*
String类型变量的使用
1. String属于引用数据类型,翻译为：字符串
2. 声明String类型变量时，使用一对""
3. String可以和8种基本数据类型变量做运算，且运算只能是连接运算：+
4. 运算的结果仍然是String类型

*/
class StringTest {
	public static void main(String[] args) {
		
		String s1 = "Hello World!";

		System.out.println(s1);

		String s2 = "a";
		String s3 = "";

		//char c = '';//编译不通过

		//***********************
		int number = 1001;
		String numberStr = "学号：";
		String info = numberStr + number;// +：连接运算
		boolean b1 = true;
		String info1 = info + b1;// +：连接运算
		System.out.println(info1);

		//***********************
		//练习1
		char c = 'a';//97   A:65
		int num = 10;
		String str = "hello";
		System.out.println(c + num + str);//107hello
		System.out.println(c + str + num);//ahello10
		System.out.println(c + (num + str));//a10hello
		System.out.println((c + num) + str);//107hello
		System.out.println(str + num + c);//hello10a

		//练习2
		//*	*
		System.out.println("*	*");
		System.out.println('*' + '\t' + '*');
		System.out.println('*' + "\t" + '*');
		System.out.println('*' + '\t' + "*");
		System.out.println('*' + ('\t' + "*"));


		//***********************

		//String str1 = 123;//编译不通过
		String str1 = 123 + "";
		System.out.println(str1);//"123"
		
		//int num1 = str1;
		//int num1 = (int)str1;//"123"

		int num1 = Integer.parseInt(str1);
		System.out.println(num1);//123
	}
}
