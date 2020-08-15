/*
	数据输入：
		导包：
			import java.util.Scanner;
		创建对象：
			Scanner sc = new Scanner(System.in);
		接收数据：
			int x = sc.nextInt();
*/
import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		//创建对象
		Scanner sc = new Scanner(System.in);
		
		//接收数据
		int x = sc.nextInt();
		
		//输出数据
		System.out.println("x:" + x);
	}
}