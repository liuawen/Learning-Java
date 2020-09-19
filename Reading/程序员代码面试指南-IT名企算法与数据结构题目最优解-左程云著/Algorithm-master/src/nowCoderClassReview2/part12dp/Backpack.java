package part12dp;

/**
 * Created by Dell on 2017-07-30.
 */
public class Backpack {

    public int maxValue(int[] w, int[] v, int n, int cap) {
        int[] dp=new int[cap+1];//减少了存储空间
        for(int i=0;i<n;i++){//当前物品
            for(int j = cap; j >= w[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp[cap];
    }

    //
    public int maxValue1(int[] w, int[] v, int n, int cap) {
        int[][] dp=new int[n][cap+1];
        for(int i=0;i<cap+1;i++){//第一行dp价值不超过cap下最大价值
             if(i>=w[0]){
                 dp[0][i]=v[0];
             }
        }
        //动态规划，
        for(int i=1;i<n;i++){
            for(int j=1;j<cap+1;j++){
                if(j<w[i]){
                    dp[i][j]=dp[i-1][j];
                }else{//在装入j之后，和不装入，选取最大值
                    dp[i][j]=Math.max(v[i]+dp[i-1][j-w[i]],dp[i-1][j]);
                }
            }
        }
        return dp[n-1][cap];
    }
}
