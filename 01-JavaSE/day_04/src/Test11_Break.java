/**
 * @author Liu Awen
 * @create 2018-05-08 16:00
 */
/*
break：
（1）用于switch..case
作用：结束switch
（2）用于循环结构
作用：结束当前循环

结论：结束一个循环有两种情况（1）循环条件不满足（2）遇到了break等中断
*/
class Test11_Break{
    public static void main(String[] args){
        //3、从键盘输入整数，输入0结束，统计输入的正数、负数的个数。
        //因为需要从键盘输入
        java.util.Scanner input = new java.util.Scanner(System.in);

        int positive = 0;
        int negative = 0;
        while(true){//true，表示条件成立，while(true)条件永远成立
            System.out.print("请输入整数：");
            int num = input.nextInt();

            if(num>0){
                positive++;
            }else if(num<0){
                negative++;
            }else{//num=0
                //结束当前循环
                break;
            }
        }
        System.out.println("正数的个数：" + positive);
        System.out.println("负数的个数：" + negative);

        //for(;;){

        //}
    }
}