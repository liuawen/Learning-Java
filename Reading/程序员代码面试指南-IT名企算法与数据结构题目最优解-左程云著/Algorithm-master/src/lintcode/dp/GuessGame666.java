package lintcode.dp;

/**
 * Created by Dell on 2017-08-31.
 */
public class GuessGame666 {


    //猜数二
    public int getMoneyAmount(int n) {
        // Write your code here
        int[][] dp=new int[n+1][n+1];
        for (int i = 2; i <= n; ++i) {
            for (int j = i - 1; j > 0; --j) {
                int global_min = Integer.MAX_VALUE;
                for (int k = j + 1; k < i; ++k) {
                    int local_max = k + Math.max(dp[j][k - 1], dp[k + 1][i]);
                    global_min = Math.min(global_min, local_max);
                }
                dp[j][i] = j + 1 == i ? j : global_min;
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                System.out.print(dp[i][j]+"   ");
            }
            System.out.println();
        }
        return dp[1][n];
    }

    //用二分法猜数，返回几次才能猜中
//    public int guessNumber(int n) {
//        int start = 1, end = n;
//
//        while(start < end) {
//            int mid = start + (end - start) / 2;   //备注
//
//            if(guess(mid) == 0) {
//                return mid;
//            }
//            else if(guess(mid) == 1) {  //说明target比mid值要大
//                start = mid + 1;        //起点设置为mid后一位
//            }
//            else {                    //说明target比mid值要小
//                end = mid;            //终点设置为mid
//            }
//        }
//        return start;
//    }

}
