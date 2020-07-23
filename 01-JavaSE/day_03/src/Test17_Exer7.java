/**
 * @author Liu Awen
 * @create 2018-05-08 12:56
 */
/*
7、赌数游戏：随机产生3个1-6的整数，
如果三个数相等，那么称为“豹子”，
如果三个数之和大于9，称为“大”，
如果三个数之和小于等于9，称为“小”，
用户从键盘输入押的是“豹子”、“大”、“小”，并判断是否猜对了
*/
class Test17_Exer7{
    public static void main(String[] args){
        //1、随机产生3个1-6的整数
        int a = (int)(Math.random()*6 + 1);
        int b = (int)(Math.random()*6 + 1);
        int c = (int)(Math.random()*6 + 1);
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("c="+c);

        //2、判断随机产生的数的结果是什么
        String result;
        if(a == b && b == c){
            result = "豹子";
        }else if(a + b + c > 9){
            result = "大";
        }else{
            result = "小";
        }

        //3、用户从键盘输入押的是“豹子”、“大”、“小”
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("请押宝（豹子、大、小）：");
        String ya = input.next();

        //4、判断用户的输入是否猜对了
        //比较ya与result是否相同
        //if(result==ya){
        if(result.equals(ya)){
            System.out.println("猜对了");
        }else{
            System.out.println("猜错了");
        }
    }
}