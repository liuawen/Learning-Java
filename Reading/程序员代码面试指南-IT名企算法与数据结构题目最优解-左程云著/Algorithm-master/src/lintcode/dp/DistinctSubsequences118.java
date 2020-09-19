package lintcode.dp;

/**
 * Created by Dell on 2017-08-31.
 */
public class DistinctSubsequences118 {
    public int numDistinct(String S, String T) {
        // write your code here
        if(S==null||S.length()==0){
            return 0;
        }
        if(T==null||T.length()==0){
            return 1;
        }
        if(T.length()>=S.length()){
            return S.equals(T)?1:0;
        }
        char[] s=S.toCharArray();
        char[] t=T.toCharArray();
        int[][] dp=new int[T.length()][S.length()];
        //初始化第一行
        dp[0][0]=s[0]==t[0]?1:0;
        for(int j=1;j<S.length();j++){
            dp[0][j]=t[0]==s[j]?dp[0][j-1]+1:dp[0][j-1];
        }
        //转移方程，dp[i][j]=t[i]==s[j]?dp[i][j-1]+dp[i-1][j-1]:dp[i][j-1];
        for(int i=1;i<T.length();i++){
            for(int j=i;j<S.length();j++){
                dp[i][j]=(t[i]==s[j])?dp[i][j-1]+dp[i-1][j-1]:dp[i][j-1];
            }
        }
        return dp[T.length()-1][S.length()-1];
    }
}
