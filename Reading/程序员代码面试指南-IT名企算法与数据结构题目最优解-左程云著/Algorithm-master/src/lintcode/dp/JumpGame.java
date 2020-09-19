package lintcode.dp;

/**
 * Created by Dell on 2017-08-31.
 */
public class JumpGame {
    public int jump(int[] A) {
        // write your code here
        int[] dp=new int[A.length];
        for(int i=1;i<A.length;i++){
            dp[i]=Integer.MAX_VALUE;//标记为不可达
        }
        for(int i=0;i<A.length-1;i++){
            for(int j=i+1;j<=i+A[i];j++){
                dp[j]=Math.min(dp[j],dp[i]+1);
            }
        }
        return dp[A.length-1];
    }
}
