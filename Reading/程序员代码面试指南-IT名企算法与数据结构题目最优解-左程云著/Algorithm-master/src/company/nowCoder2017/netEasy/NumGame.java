package company.nowCoder2017.netEasy;

import java.util.Scanner;

/**
 * Created by Dell on 2017-09-08.
 */
public class NumGame
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        int sum=0;
        for(int i = 0; i < n; i++){
            arr[i]= sc.nextInt();
            sum+=arr[i];
        }
        System.out.println(canGet(arr,sum));

    }
    //全部用背包问题求解,没见物品放或不放
    public static int canGet(int[] arr,int cur){
        boolean[] dp=new boolean[cur+1];
        dp[0]=true;
        for(int i=0;i<arr.length;i++){
            for(int j=cur;j>=arr[i];j--){
                if(!dp[j]&&j-arr[i]>=0){
                    dp[j]=dp[j-arr[i]];
                }
            }
        }
//        for(int i=0;i<=cur;i++){
//            System.out.print(dp[i]+"    ");
//        }
//        System.out.println();
        //遍历最后一行，找到第一个false的即可，找不到，返回cur+1
        for(int i=1;i<=cur;i++){
            if(!dp[i]){
                return i;
            }
        }
        return cur+1;
    }
}
