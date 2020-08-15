/*
	do...while语句

    基本格式：
        do {
			循环体语句;
		}while(条件判断语句);
		
	完整格式：
		初始化语句;
		do {
			循环体语句;
			条件控制语句;
		}while(条件判断语句);

    执行流程：		
		1:执行初始化语句
		2:执行循环体语句
		3:执行条件控制语句
		4:执行条件判断语句，看其结果是true还是false
			如果是false，循环结束
			如果是true，继续执行
		5:回到2继续
 */
public class DoWhileDemo {
    public static void main(String[] args) {
        //需求：在控制台输出5次"HelloWorld"
		//for循环实现
		for(int i=1; i<=5; i++) {
			System.out.println("HelloWorld");
		}
		System.out.println("--------");
		
		//do...while循环实现
		int j = 1;
		do {
			System.out.println("HelloWorld");
			j++;
		}while(j<=5);
		
    }
}