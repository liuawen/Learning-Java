/**
 * @author Liu Awen
 * @create 2018-05-08 14:44
 */
/*
5、输出所有的水仙花数，
所谓水仙花数是指一个3位数，其各个位上数字立方和等于其本身。
例如： 153 = 1*1*1 + 5*5*5 + 3*3*3
*/
class Test06_Exer5_2{
    public static void main(String[] args){
        System.out.println("所有的水仙花数如下：");
        //水仙花数是指一个3位数==>水仙花数的范围[100,999]
        int i=100;
        while( i<=999 ){
			/*
			对于每一个i的值，我们要干什么？
			（1）求出i的百、十、个位的值
			（2）判断i的百位的立方+十位的立方+个位的立方是否等于i，
				如果相等，就输出i
			*/
            //（1）求出i的百、十、个位的值
            int bai = i/100;
            int shi = i/10%10;
            int ge = i%10;
            //（2）判断i的百位的立方+十位的立方+个位的立方是否等于i，
            //	如果相等，就输出i
            if(i == bai*bai*bai + shi*shi*shi + ge*ge*ge){
                System.out.println(i);
            }
            i++;
        }
    }
}