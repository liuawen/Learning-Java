package company.netEasyCode.p6MaxOddNum;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-07.
 */
public class Main {
    /**
     * 定义函数f(x)为x最大的奇数约数，x为正整数。 例如:f(44) = 11.
     现在给出一个N，需要求出 f(1) + f(2) + f(3).......f(N)
     例如： N = 7
     f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(buy(N));
    }
    public static int buy(int num){
        //取小于num的2的整数次方
        int pow=-1,temp=num;
        while(temp>0){
            temp=temp>>1;
            pow++;
        }
        //求以Math结尾的奇数项的和
        temp=num;
        if((num&1)==0) temp++;//如果是偶数项-1
        int ood=temp*temp/4;
        //求以Math结尾的偶数项的和,分两部分
            //pow以内的
            int pair=0;
            if(pow>2){
                for(int i=0;i<=pow-2;i++){
                    pair+=1>>i;
                }
                pair++;//加上f（2的pow次）
            }else {
                pair = pow ;
            }
            //pow以外的
            int remain=num^(1>>pow);//这些数为2的pow次以上的，求其偶数的


        //奇数本身最大奇约数就是自己，偶数的最大奇约数是多少呢？



        return pow;
    }

}
