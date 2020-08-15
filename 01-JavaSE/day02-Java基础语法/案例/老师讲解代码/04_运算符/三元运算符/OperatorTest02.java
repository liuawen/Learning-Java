/*
	三个和尚
	
	需求：
		一座寺庙里住着三个和尚，已知他们的身高分别为150cm、210cm、165cm，
		请用程序实现获取这三个和尚的最高身高。
*/
public class OperatorTest02 {
	public static void main(String[] args) {
		//1：定义三个变量用于保存和尚的身高，单位为cm，这里仅仅体现数值即可。
		int height1 = 150;
		int height2 = 210;
		int height3 = 165;
		
		//2：用三元运算符获取前两个和尚的较高身高值，并用临时身高变量保存起来。
		int tempHeight = height1 > height2 ? height1 : height2;
		
		//3：用三元运算符获取临时身高值和第三个和尚身高较高值，并用最大身高变量保存。
		int maxHeight = tempHeight > height3 ? tempHeight : height3;
		
		//4：输出结果
		System.out.println("maxHeight:" + maxHeight);
	}
}