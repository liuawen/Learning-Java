/**
 * @author Liu Awen
 * @create 2018-05-07 15:58
 */
class Test06_Exer2{
    public static void main(String[] args){
        int i = 1;
        int j = 2;
		/*
		第一步：i++
		（1）先取i的值“1”，放起来
		（2）i自增,i=2
		第二步：j
		（1）取j的值，放起来
		第三步：
		求乘积，1*2 = 2，再把结果放起来
		第四步：++j
		（1）先自增，j=3
		（2）再取j的值“3”，放起来
		第五步：求和  2 + 3 = 5


		*/
        System.out.println(i++ * j + ++j);//5
    }
}
