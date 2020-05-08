/**
 * @author Liu Awen
 * @create 2018-05-08 14:41
 */
/*
2、打印1-100的偶数

Ctrl + 鼠标滚轮  调节编辑框字的大小
*/
class Test04_Exer2{
    public static void main(String[] args){
        //需要几个变量，1个变量，循环变量
        //循环变量i的变化是从1-100
        for(int i=1; i<=100; i++){
            if(i%2==0){
                System.out.println(i);//这句话有条件执行
            }
        }

        System.out.println("-----------------------");
        for(int i=2; i<=100; i+=2){
            System.out.println(i);
        }
    }
}