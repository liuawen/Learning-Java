class Test9{
	public static void main(String[] args){
		int year = 2018;
		
		boolean flag = year%4==0 && year%100!=0 || year%400==0;
		System.out.print(year + (flag?"是":"不是") + "闰年");
	}
}