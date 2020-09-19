package company.nowcode.spring1;

import java.util.Scanner;

/**
 * Created by Dell on 2017-09-23.
 */
public class SuperPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt();
        //先判断自己是不是质数，是就得到结果了，不是则进行下面的步骤
        if(!isPrime(num)){
            for (int i = 2; i < num; i++) {
                int j=2;
                long res=0;
                while(res<num){
                    res=(int)Math.pow(i,j);
                    j++;
                }
                if(res==num){
                    System.out.println(i+" "+--j);
                    return;
                }
            }
            System.out.println("No");
        }else{
            System.out.println(num+" 1");
        }
    }
    public static boolean isPrime(long num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

}
