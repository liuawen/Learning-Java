/**
 * @author Liu Awen
 * @create 2018-05-07 16:28
 */
/*
已知一个三位数，例如：483，如何用代码求出它的百位、十位、个位数
*/
class Test07_Exer4{
    public static void main(String[] args){
        int num = 483;

        int bai = num / 100;// 483/100 4
        //int shi = num/10%10;// 483/10 48  48%10 8
        int shi = num%100/10;// 483%100 83 83/10 8
        int ge = num % 10;// 483%10 3

        System.out.println(num + "的百位：" + bai + "，十位：" + shi +"，个位：" + ge);
        //483的百位：4，十位：8，个位：3
    }
}