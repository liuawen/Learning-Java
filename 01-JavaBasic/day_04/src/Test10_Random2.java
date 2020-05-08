/**
 * @author Liu Awen
 * @create 2018-05-08 15:54
 */
/*
在Java的核心类库中，除了在Math类中提供了random()来产生随机数，
Math.random()
还在java.util.Random类中也提供产生随机数的方法。
*/
class Test10_Random2{
    public static void main(String[] args){
        //(1)先准备产生随机数的工具
        java.util.Random tools = new java.util.Random();

        //(2)用工具获取随机数
        int num = tools.nextInt();
        System.out.println("随机整数：" + num) ;//eg:随机整数：-884011449

        double d = tools.nextDouble();
        System.out.println("随机小数：" + d) ;//eg:随机小数：0.3367837139245098

        //(3)用工具获取一定范围内的随机值
        int rangeNum = tools.nextInt(10);//[0,10)
        System.out.println("随机[0,10)整数：" + rangeNum) ;//eg:随机[0,10)整数：1
    }
}