package lintcode.dp;

/**
 * Created by Dell on 2017-08-31.
 */
public class EditDistance119 {
    public int minDistance(String word1, String word2) {
        // write your code here
        if(word1==null||word1.length()==0){
            return word2==null?0:word2.length();
        }
        if(word2==null||word2.length()==0){
            return word1.length();
        }
        char[] row=word2.toCharArray();
        char[] col=word1.toCharArray();
        int[][] dp=new int[row.length+1][col.length+1];
        //初始化
        for(int i=1;i<dp.length;i++){
            dp[i][0]=i;
        }
        for(int j=1;j<dp[0].length;j++){
            dp[0][j]=j;
        }
        //状态转移方程dp[i][j]=row[i]==col[j]?dp[i-1][j-1]:Math.min(上左斜)+1
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j]=row[i-1]==col[j-1]?dp[i-1][j-1]:Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }
        return dp[row.length][col.length];
    }
}
