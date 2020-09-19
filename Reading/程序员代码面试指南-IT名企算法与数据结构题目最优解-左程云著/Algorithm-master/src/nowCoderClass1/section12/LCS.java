package nowCoderClass1.section12;

/**
 * 求两串的公共最长子序列，设计一个矩阵，依次匹配
 * Created by Dell on 2017-06-04.
 */
public class LCS {
    public int findLCS(String A, int n, String B, int m) {
        int[][] dp=new int[n+1][m+1];
        char[] a=A.toCharArray();int al=n;
        char[] b=B.toCharArray();int bl=m;
        for(int i=1;i<=al;i++){
            for(int j=1;j<=bl;j++){
                if(a[i-1]==b[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1];
            }
        }
        return dp[al][bl];
    }
//    public int findLCS(String A, int n, String B, int m) {
//        char[] a = A.toCharArray();
//        char[] b = B.toCharArray();
//        int[][] dp = new int[n+1][m+1];
//        // 为了避免越界，都从数组下标 1 开始
//        for (int i = 1; i <= n; i++){
//            for (int j = 1; j <= m; j++){
//                if (a[i-1] == b[j-1]){
//                    dp[i][j] = dp[i-1][j-1] + 1;//相等的时候选择斜上角的
//                }
//                else{
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);//不相等时选上和左较大的
//                }
//            }
//        }
//        return dp[n][m];
//    }
}
