package lintcode.dp;

/**
 * 最长公共子序列，可以不连续
 * Created by Dell on 2017-08-29.
 */
public class LCS {
    //状态转移方程：dp[i][j]=A[i-1]==B[j-1]?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]);
    public int longestCommonSubsequence(String A, String B) {
        if(A==null||B==null||A.equals("")||B.equals("")){
            return 0;
        }
        int[][] dp=new int[A.length()+1][B.length()+1];//第0行，0列是为了方便状态方程转移
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]=A.charAt(i-1)==B.charAt(j-1)?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[A.length()][B.length()];
    }
}
