class IfExer {
	public static void main(String[] args) {
		int x = 4;
		int y = 1;
		if (x > 2) 
			if (y > 2) 
                System.out.println(x + y);
				//System.out.println("atguigu");
			else //就近原则
				System.out.println("x is " + x);
		

		//课后练习3：测算狗的年龄
		int dogAge = 6;
		if(dogAge >= 0 && dogAge <= 2){
			System.out.println("相当于人的年龄：" + dogAge * 10.5);
		}else if( dogAge > 2){
			System.out.println("相当于人的年龄：" + (2 * 10.5 + (dogAge - 2) * 4));
		}else{
			System.out.println("狗狗还没出生呢！");
		}

		//课后练习4：如何获取一个随机数：10 - 99
		int value = (int)(Math.random() * 90 + 10);// [0.0,1.0) --> [0.0,90.0) --->[10.0, 100.0) -->[10,99]
		System.out.println(value);
		//公式：[a,b]  :  (int)(Math.random() * (b - a + 1) )+ a
	}
}
