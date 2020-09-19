package jiuzhang.dp;

/**
 * Created by Dell on 2017-08-20.
 */
public class HouseRobber {
    public long houseRobber(int[] A) {
        // write your code here
        int n=A.length;
        if(n==0)
            return 0;
        long[] dp=new long[2];//用奇偶来记录
        dp[0]=0;
        dp[1]=A[0];

        for(int i=2;i<=n;i++){
            dp[i%2]=Math.max(A[i-1]+dp[(i-2)%2],dp[(i-1)%2]);
        }
        return dp[A.length];
    }
    public int houseRobber2(int[] A) {
        // write your code here
        int n=A.length;
        if(n==0)
            return 0;
        if(n==1){
            return A[0];
        }
        if(n==2){
            return Math.max(A[0],A[1]);
        }
        int[] dp=new int[n+1];
        //先算打劫第二个至第n-1个房屋的最大价值
        //再算打劫第一个至第n-2个房屋的最大价值
        dp[2]=A[1];
        for(int i=3;i<=n;i++){
            dp[i]=Math.max(A[i-1]+dp[i-2],dp[i-1]);
        }
        dp[1]=A[0];
        for(int i=2;i<n;i++){
            dp[i]=Math.max(A[i-1]+dp[i-2],dp[i-1]);
        }
        return Math.max(dp[A.length],dp[A.length-1]);
    }
}
