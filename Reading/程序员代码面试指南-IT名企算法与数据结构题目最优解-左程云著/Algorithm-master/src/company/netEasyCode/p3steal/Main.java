package company.netEasyCode.p3steal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Dell on 2017-08-07.
 */
public class Main {
    /**
     * 跳石板
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        System.out.println(jump(N,M));
    }
    public static int jump(int N,int M){
        int[] dp=new int[M+1];
        for(int i=N+1;i<=M;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        ArrayList<Integer> list=null;
        for(int i=N;i<M;i++){
            if(dp[i]!=Integer.MAX_VALUE){
                list=allFactor(i);
                for(int e:list){
                    if(i+e<=M){
                        dp[i+e]=Math.min(dp[i+e],dp[i]+1);
                    }
                }
            }
        }
        return dp[M]==Integer.MAX_VALUE?-1:dp[M];
    }
    //获取所有的因子
    public static ArrayList<Integer> allFactor(int n){//获得n的所有因子 除1 n外
         ArrayList list=new ArrayList();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                list.add(i);
                if(i!=n/i)list.add(n/i);
            }
        }
        return list;
    }
}
