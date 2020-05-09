/**
 * @author Liu Awen
 * @create 2018-05-09 22:45
 */
/*
3、数组的练习3：
	用一个数组，保存星期一到星期天的7个英语单词，
	从键盘输入1-7，显示对应的单词
*/
class Test05_Exer3{
    public static void main(String[] args){
        //用一个数组，保存星期一到星期天的7个英语单词，
        String[] weeks = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        //	从键盘输入1-7，显示对应的单词
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("请输入星期（1-7）：");
        int week = input.nextInt();

        if(week<1 || week>7){
            System.out.println("输入有误！");
        }else{
            //week对应的英语单词在weeks数组中
            //week=1，weeks[0]
            //week=2，weeks[1]
            //...
            System.out.println(week+"对应的星期的单词是：" + weeks[week-1]);
        }

    }
}