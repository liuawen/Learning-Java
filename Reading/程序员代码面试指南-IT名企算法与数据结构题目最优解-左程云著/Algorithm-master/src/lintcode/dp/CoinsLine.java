package lintcode.dp;

/**
 * Created by Dell on 2017-08-30.
 */
public class CoinsLine {
    //化搜索树--》记忆化搜索--》（倒置）--》dp
    //dp[i]表示先手的胜负情况dp[i]=(dp[i-1-1]&&dp[i-1-2])||(dp[i-2-1]&&dp[i-2-2])
    public boolean firstWillWin(int n) {
       boolean[] dp=new boolean[n+1];
       dp[0]=false;
       dp[1]=true;dp[2]=true;dp[3]=false;
       int count=4;
       while(count<=n){
           dp[count]=(dp[count-2]&&dp[count-3])||(dp[count-3]&&dp[count-4]);
           count++;
       }
       return dp[n];
    }
}
