package company.netEasyCollect.p1;

import java.util.Scanner;

/**
* Created by Dell on 2017-08-07.
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for (int i = 0; i < arr.length; i ++) {
                arr[i] = sc.nextInt() >> 10;
                sum += arr[i];
            }
            // dp[j]表示在容量为j的情况下可存放的重量
            // 如果不放arr[i]重量为dp[j],如果放arr[i]重量为dp[j-arr[i]]+arr[i];
            int[] dp = new int[sum / 2 + 1];
            for (int i = 0; i < n; i ++) {
                for (int j = sum / 2; j >= arr[i]; j --) {
                    dp[j] = Math.max(dp[j], dp[j - arr[i]] + arr[i]);
                }
            }
            System.out.println(Math.max(dp[sum / 2], sum - dp[sum / 2]) << 10);
        }
    }
}
