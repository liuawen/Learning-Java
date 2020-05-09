package homework;

/**
 * @author Liu Awen
 * @create 2018-05-09 21:19
 */
//案例需求：从键盘分别输入年、月、日，使用循环for+if实现，判断这一天是当年的第几天
class Day04_Test05{
    public static void main(String[] args){
        //1、从键盘分别输入年、月、日
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("年：");
        int year = input.nextInt();

        System.out.print("月：");
        int month = input.nextInt();

        System.out.print("日：");
        int day = input.nextInt();

        int days = day;//累加了第month月的day天
        //累加[1,month-1]的满月天数
        for(int i=1; i<month; i++){
            if(i==4 || i==6 || i==9 || i==11){
                days+=30;
            }else if(i==2){
                if(year%4==0 && year%100!=0 || year%400==0){
                    days+=29;
                }else{
                    days+=28;
                }
            }else{
                days+=31;
            }
        }

        //5、输出结果
        System.out.println(year + "年" + month + "月" + day + "日是这一年的第" + days + "天");
    }
}