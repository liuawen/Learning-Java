/**
 * @author Liu Awen
 * @create 2018-05-08 11:39
 */
/*
1、从键盘输入一个分数，如果60分（含）以上，就打印合格，如果60分以下，就打印不合格
提示：从键盘输入
代码  一些空行  阅读
*/
class Test05_Exer1{
    public static void main(String[] args){
        //1、从键盘输入一个分数
        java.util.Scanner input = new java.util.Scanner(System.in);
        java.util.Scanner x = new java.util.Scanner(System.in);

        System.out.print("请输入成绩：");
        int score = input.nextInt();

        //2、判断
        if(score >= 60){
            System.out.println("合格");
        }else{
            System.out.println("不合格");
        }
    }
}