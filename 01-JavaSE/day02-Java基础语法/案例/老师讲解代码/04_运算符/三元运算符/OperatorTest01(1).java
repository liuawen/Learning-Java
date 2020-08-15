/*
	两只老虎
	
	需求：
		动物园里有两只老虎，已知两只老虎的体重分别为180kg、200kg，
		请用程序实现判断两只老虎的体重是否相同。
*/
public class OperatorTest01 {
	public static void main(String[] args) {
		//1：定义两个变量用于保存老虎的体重，单位为kg，这里仅仅体现数值即可。
		int weight1 = 180;
		int weight2 = 200;
		
		//2：用三元运算符实现老虎体重的判断，体重相同，返回true，否则，返回false。
		boolean b = weight1 == weight2 ? true : false;
		
		//3：输出结果
		System.out.println("b:" + b);
	}
}