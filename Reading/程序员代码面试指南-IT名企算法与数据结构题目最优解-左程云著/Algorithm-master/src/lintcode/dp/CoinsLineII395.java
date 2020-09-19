package lintcode.dp;

/**
 * Created by Dell on 2017-08-31.
 */
public class CoinsLineII395
{
    public boolean firstWillWin(int[] values) {
        // write your code here
        int target=0;
        for(int i=0;i<values.length;i++){
            target+=values[i];
        }
        if(values.length<4){
            if(values.length<=2) return true;
            return (values[0]+values[1])>values[2];

        }
        int[] dp=new int[values.length+1];
        dp[1]=values[values.length-1];
        dp[2]=values[values.length-2]+values[values.length-1];
        dp[3]=values[values.length-3]+values[values.length-2];
        for(int i=4;i<=values.length;i++){
            dp[i]=Math.max(Math.min(dp[i-2],dp[i-3]),Math.min(dp[i-3],dp[i-4]));
        }
        return ((target&1)==1)?(dp[values.length]>=target>>1):(dp[values.length]>target>>1);
    }
}
