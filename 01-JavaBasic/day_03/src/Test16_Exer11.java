/**
 * @author Liu Awen
 * @create 2018-05-08 12:56
 */
/*
11、从键盘分别输入年、月、日，判断这一天是当年的第几天
   注：判断一年是否是闰年的标准：
       1）可以被4整除，但不可被100整除
       2）可以被400整除
*/
class Test16_Exer11{
    public static void main(String[] args){
        //1、从键盘分别输入年、月、日
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("年：");
        int year = input.nextInt();

        System.out.print("月：");
        int month = input.nextInt();

        System.out.print("日：");
        int day = input.nextInt();

        //判断这一天是当年的第几天==>从1月1日开始，累加到xx月xx日这一天
        //(1)[1,month-1]个月满月天数
        //(2)第month个月的day天
        //(3)单独考虑2月份是否是29天（依据是看year是否是闰年）

        //2、声明一个变量days，用来存储总天数
        //int days = 0;
        //累加第month个月的day天
        //days += day;

        //修改上面的代码，直接把days初始化为day
        int days = day;

        //3、累加[1,month-1]个月满月天数
		/*
		switch(month){
			//case 1://不需要累加满月天数
			case 2:
				//累加1月的满月天数
				days += 31;
				break;
			case 3:
				//累加1月和2月的满月天数
				days += 31 + 28;
				break;
			case 4:
				//累加1月、2月、3月的满月天数
				days += 31 + 28 + 31;
				break;
			....
		}
		*/
        switch(month){
            case 12:
                //累加的1-11月
                days += 30;//这个30是代表11月份的满月天数
                //这里没有break，继续往下走
            case 11:
                //累加的1-10月
                days += 31;//这个31是代表10月的满月天数
                //这里没有break，继续往下走
            case 10:
                days += 30;//9月
            case 9:
                days += 31;//8月
            case 8:
                days += 31;//7月
            case 7:
                days += 30;//6月
            case 6:
                days += 31;//5月
            case 5:
                days += 30;//4月
            case 4:
                days += 31;//3月
            case 3:
                days += 28;//2月
                //4、在这里考虑是否可能是29天
                if(year%4==0 && year%100!=0 || year%400==0){
                    days++;//多加1天
                }
            case 2:
                days += 31;//1月
        }

        //5、输出结果
        System.out.println(year + "年" + month + "月" + day + "日是这一年的第" + days + "天");
    }
}