package company.lexin.p3;

import java.util.Scanner;

/**
 * Created by Dell on 2017-09-23.
 */
public class Main {
    //暴力递归
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
//        boolean[] dp=new boolean[Math.max(6,n+1)];//表示先手还剩i个硬币时的状态，
//        dp[0]=false;dp[1]=true;dp[2]=true;dp[3]=true;dp[4]=true;dp[5]=true;
//        for(int i=6;i<=n;i++){//求先手还剩6枚时的情况
//            for(int j=1;j<=m;j++){//每次可以取一个至m个硬币
//                if(dp[i-j]){
//                    dp[i]=true;
//                }
//            }
//        }
    }

    public static void violence(int n,int m){
        for(int i=1;i<=m;i++){

        }
    }

}
