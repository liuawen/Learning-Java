/**
 * @author Liu Awen
 * @create 2018-05-08 11:39
 * 代码风格对齐 好看   找错比较容易点
 */
/*
2、岳小鹏参加Java考试，他和父亲岳不群达成承诺：如果：
成绩为100分时，奖励一辆BMW；
成绩为(80，99]时，奖励一台iphone7plus；
当成绩为[60,80]时，奖励一个 iPad；
其它时，什么奖励也没有。
请从键盘输入岳小鹏的期末成绩，并加以判断
*/
class Test07_Exer2{
    public static void main(String[] args){
        //1、从键盘输入岳小鹏的期末成绩
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("请输入岳小鹏的成绩：");
        int score = input.nextInt();

        //2、判断
        if(score == 100){
            System.out.println("奖励一辆BMW");
        }else if(score>80){
            System.out.println("奖励一台iphone7plus");
        }else if(score>=60){
            System.out.println("奖励一个 iPad");
        }else{
            System.out.println("什么也没有");
        }
    }
}