/*
	if语句格式2

	格式：
		if (关系表达式) {
			语句体1;	
		} else {
			语句体2;	
		}
	
	执行流程：
		1:首先计算关系表达式的值
		2:如果关系表达式的值为true就执行语句体1
		3:如果关系表达式的值为false就执行语句体2
		4:继续执行后面的语句内容
*/
public class IfDemo02 {
	public static void main(String[] args) {
		System.out.println("开始");
		
		//定义两个变量
		int a = 10;
		int b = 20;
		
		//需求：判断a是否大于b，如果是，在控制台输出：a的值大于b，如果不是，在控制台输出：a的值不大于b
		
		
		
		System.out.println("结束");
	}
}