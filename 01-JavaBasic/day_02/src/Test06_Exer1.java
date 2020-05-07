/**
 * @author Liu Awen
 * @create 2018-05-07 15:56
 */
class Test06_Exer1{
    public static void main(String[] args){
        int i = 1;
		/*
		第一步：i++
		（1）先取i的值“1”，放起来
		（2）i自增，i=2
		第二步：++i
		（1）先自增，i=3
		（2）再取i的值“3”，放起来
		第三步：计算求和 1 + 3 = 4

		*/
		//1 + 3 = 4
        System.out.println(i++ + ++i);//4
        System.out.println(i);//3
    }
}