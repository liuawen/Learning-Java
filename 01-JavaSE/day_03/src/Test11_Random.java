/**
 * @author Liu Awen
 * @create 2018-05-08 12:54
 */
class Test11_Random{
    public static void main(String[] args){
        //使用Math.random() 产生随机数
        System.out.println(Math.random());
		/*
		Math.random()：产生的随机数是[0,1)的小数
		*/


        //如果我想要产生[1,10]之间的整数
        double rand = Math.random();//[0,1)的小数

        rand = rand * 10; //[0,10)的小数

        rand = rand + 1; //[1,11)的小数

        int num = (int)rand;//[1,10]的整数

        System.out.println(num);

        int m = (int)(Math.random()*10 + 1);
        System.out.println("m = " + m);
//        随机产生一个两位数 整数 [10,99]
        int r =  (int)(Math.random()*90 + 10);
        System.out.println("r = " + r);
    }
}