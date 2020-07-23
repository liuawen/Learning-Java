/**
 * @author Liu Awen
 * @create 2018-05-08 18:48
 */
/*
7、输入两个正整数m和n，求其最大公约数和最小公倍数
*/
//要考虑多多的  别那么肤浅   垃圾
class Test14_Exer7{
    public static void main(String[] args){
        //输入两个正整数m和n
        java.util.Scanner input = new java.util.Scanner(System.in);

        int m;
        while(true){
            System.out.print("请输入第一个正整数m的值：");
            m = input.nextInt();
            if(m<=0){
                System.out.println(m + "不是正整数，请重写输入！");
            }else{
                break;
            }
        }
        int n;
        while(true){
            System.out.print("请输入第一个正整数n的值：");
            n = input.nextInt();
            if(n<=0){
                System.out.println(n + "不是正整数，请重写输入！");
            }else{
                break;
            }
        }

        System.out.println("两个正整数：" + m + "," + n);

        //求m和n的最大公约数和最小公倍数
		/*
		1、概念
		公约数：能够把m和n都整除，就是它俩的公约数
		例如：6和9，公约数：1,3
		      9和18，公约数：1,3,9
			  5和13，公约数：1
		公倍数：能够被m和n都整除的，就是它俩的公倍数
		例如：6和9，公倍数：18,36....
			   9和18，公倍数：18,36...
			    5和13，公倍数：65,....

		2、如何找最大公约数
		例如：6和9
			从6开始，9%6==0?  6%6==0?
					 9%5==0?   6%5==0?
					 9%4==0?   6%4==0?
					 9%3==0?   6%3==0?    binggou找到了  结束查找
		例如：9和18
			从9开始	  9%9==0?  18%9==0?   binggou找到了  结束查找
		例如：5和13
			从5开始   5%5==?  13%5==0?
					  5%4==?  13%4==0?
					  5%3==?  13%3==0?
					  5%2==?  13%2==0?
					  5%1==?  13%1==0?   binggou找到了  结束查找
					其实只要找到5的平方根就可以了
		*/

        //第一步：找出m和n中最大值和最小值
        int max = m>=n ? m : n;
        int min = m<n ? m : n;

        //第二步：从小的开始查找
        //这里的1也可以修改为min的平方根
        int maxYue = 1;
        for(int i=min; i>=1; i--){
            //看i是否能够同时把m和n都整除
            if(m%i==0 && n%i==0){
                maxYue = i;
                break;
            }
        }
        System.out.println(maxYue +"是" + m + "和" + n + "的最大公约数");

        //最小公倍数 = m*n / 最大公约数
        //System.out.println(m*n/maxYue +"是" + m + "和" + n + "的最小公倍数");

        //如果不知道这个公式
        //从max开始找，一直找到m*n
        for(int i=max; i<=m*n; i++){
            if(i%m==0 && i%n==0){
                System.out.println(i +"是" + m + "和" + n + "的最小公倍数");
                break;
            }
        }
    }
}
