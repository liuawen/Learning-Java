package homework;

/**
 * @author Liu Awen
 * @create 2018-05-09 15:17
 */
//案例：已知2019年1月1日是星期二，从键盘输入2019年的任意一天，请判断它是星期几
    // 年月日 计算得天数   + 1  % 7     0 - 6
class Day03_Test7{
    public static void main(String[] args){
        //1、从键盘分别输入年、月、日
        java.util.Scanner input = new java.util.Scanner(System.in);

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

        //3、累加[1,month-1]个月满月天数   一年365  30天 3 6 9 11
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
                days += 28;//2月，因为2019年的2月是28天
            case 2:
                days += 31;//1月
        }

        //days 里面存的是这一天是这一年的第几天
        //已知2019年1月1日是星期二
        //假设我输入的就是1月1日，那么days中就是1
        int week = 1;//2018年12月31日的星期
        week += days;
        week %= 7;
        System.out.print(month+"月" + day +"日是这一年的第"+days+"天，是星期" + (week==0?"天":week)) ;

    }
}