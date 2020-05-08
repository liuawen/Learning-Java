/**
 * @author Liu Awen
 * @create 2018-05-08 14:37
 */
//1、求1-100的和
class Test03_Exer1{
    public static void main(String[] args){
		/*
		需要几个变量？
		（1）循环变量：i从1变到100
		（2）总和：sum
		*/
        int sum = 0;
        //循环要执行100次，依次是i=1,i=2,i=3,i=4....i=100，当i=101时因为条件不满足结束
        for(int i=1; i<=100; i++){
            //循环体语句：把每一个i的值累加到sum中
            sum += i;
        }
        //输出最后的结果，不用在循环体中，因为在循环结束后最后输出一次
        System.out.println("sum = " + sum);
        System.out.println("用公式");
        System.out.println("1-100的和：" + (1+100)*100/2);
    }
}