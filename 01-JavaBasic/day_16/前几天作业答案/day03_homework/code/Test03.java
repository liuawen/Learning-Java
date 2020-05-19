class Test03{
	public static void main(String[] args){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("请输入总价格：");
		double discount = 1;
		double totalPrice = input.nextDouble();
		if(totalPrice>=500){
			discount = 0.5;
		}else if(totalPrice>=400){
			discount = 0.6;
		}else if(totalPrice>=300){
			discount = 0.7;
		}else if(discount>=200){
			discount = 0.8;
		}else if(discount >= 0){
			discount = 1;
		}else{
			System.out.println("输入有误！");
		}
		System.out.println("总价：" + totalPrice);
		System.out.println("折扣：" + discount);
		System.out.println("折扣后总价：" + totalPrice*discount);
	}
}