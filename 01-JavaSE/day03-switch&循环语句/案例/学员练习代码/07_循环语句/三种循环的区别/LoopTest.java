/*
	三种循环的区别
 */
public class LoopTest {
    public static void main(String[] args) {
		//for循环
		for(int i = 3; i<3; i++) {
			System.out.println("我爱Java");
		}
		System.out.println("--------");
		
		//while循环
		int j = 3;
		while(j<3) {
			System.out.println("我爱Java");
			j++;
		}
		System.out.println("--------");
		
		//do...while循环
		int k = 3;
		do {
			System.out.println("我爱Java");
			k++;
		}while(k<3);
    }
}