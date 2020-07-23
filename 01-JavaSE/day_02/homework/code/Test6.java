/*
1、为抵抗洪水，战士连续作战89小时，编程计算共多少天零多少小时？
*/
class Test6{
	public static void main(String[] args){
		int hours = 89;
		int day = hours / 24;
		int hour = hours % 24;
		System.out.println("为抵抗洪水，战士连续作战89小时：");
		System.out.println(hours + "是" + day + "天" + hour + "小时");
	}
}