package company.nowCoder2017.didi;

import java.util.Scanner;

/**
 * Created by Dell on 2017-09-09.
 */
public class ComposeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target=sc.nextInt();
        int[] arr=new int[n];
        for(int i = 0; i < n; i++){
            arr[i]= sc.nextInt();
        }
        System.out.println(get(arr,target));
    }
    public static long get(int[] arr,int target){
        long[] dp=new long[target+1];
        dp[0]=1;
        for(int i=0;i<arr.length;i++){
            for(int j=target;j>=arr[i];j--){
                dp[j]+=dp[j-arr[i]];
            }
        }
        return dp[target];
    }


}
