package codingInterviewGuide.part4dp;

/**
 * Created by Dell on 2017-08-10.
 */
public class MaxCommomSubStr {
    public int findLCS(String A, int n, String B, int m) {
        // write code here
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        int[][] dp=new int[n+1][m+1];//b数组作为横着的

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i]==b[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else{
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[n][m];//如果要返回最长的子序列，从右下角，找到左边和上边均小于当前的位置的字符，连起来即可
    }
}
