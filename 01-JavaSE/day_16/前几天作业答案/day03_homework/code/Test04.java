class Test04{
	public static void main(String[] args){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("请输入月份：");
		int month = input.nextInt();
		
		System.out.print("请输入日期：");
		int day = input.nextInt();
		
		if((month==1 && day>=20)  || (month==2 && day<=18)){
			System.out.println("生日"+month+"月"+day+"日是水瓶座");
		}
	}
}