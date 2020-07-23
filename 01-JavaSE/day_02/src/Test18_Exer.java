/**
 * @author Liu Awen
 * @create 2018-05-07 22:27
 */
/*
1、定义一个int类型变量，保存年份，判断这个年份是否是闰年
注：判断一年是否是闰年的标准：
       1）可以被4整除，但不可被100整除
       2）可以被400整除
	   */
class Test18_Exer{
    public static void main(String[] args){
        int year = 2000;

        boolean result = year%4==0 && year%100!=0 || year%400==0;
        System.out.println(year + (result?"是闰年":"不是闰年"));

        if ( year%4==0 && year%100!=0 || year%400==0){
            System.out.println(year + "是闰年");
        }
    }
}
