/**
 * @author Liu Awen
 * @create 2018-05-07 16:31
 * 理解变量的含义
 * 对上下文的影响
 */
//判断运行结果
class Test08_Exer5{
    public static void main(String[] args){
        int number1 = 10;
        int number2 = 20;
        int number3 = number1 + number2;//30
        System.out.println("Number3 = " + number3);//30

        int number4 = 50;
        int number5 = number4 - number3;// 50 - 30
        System.out.println("Number5 = " + number5);//20
    }
}