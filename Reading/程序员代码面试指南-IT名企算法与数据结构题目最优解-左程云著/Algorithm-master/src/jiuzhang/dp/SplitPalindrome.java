package jiuzhang.dp;

/**
 * Created by Dell on 2017-08-20.
 */
public class SplitPalindrome {

    public int minCut(String s) {
        int[] dp=new int[s.length()+1];
        dp[0]=-1;
        boolean[][] judge=isPalindrome(s);
        for(int i=1;i<=s.length();i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=1;j<=i;j++){
                if(judge[i-j][i-1]&&dp[i-j]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[i-j]+1);
                }
            }
        }
        return dp[s.length()];
    }
    public boolean[][] isPalindrome(String s){
        boolean[][] judge=new boolean[s.length()][s.length()];
        for(int i=0;i<judge.length;i++){
            judge[i][i]=true;
        }
        for(int j=1;j<judge.length;j++){
            judge[j-1][j]=s.charAt(j)==s.charAt(j-1);
        }
        for(int begin=2;begin<judge.length;begin++){
            for(int j=0;j+begin<judge.length;j++){
                judge[j][begin+j]=(s.charAt(j)==s.charAt(begin+j))&&judge[j+1][begin+j-1];
            }
        }
        return judge;
    }
}
