package lintcode.dp;

/**
 * Created by Dell on 2017-08-29.
 */
public class BackpackI {
    //在n个物品中挑选若干物品装入背包，最多能装多满？
    //状态转移方程为：dp[i][j]=dp[i-1][j-A[i]]||dp[i-1][j]
    public int backPack(int m, int[] A) {
        boolean[] dp=new boolean[m+1];
        //初始化第一列
        dp[0]=true;
        //初始化第一行
        if(A[0]<=m){
            dp[A[0]]=true;
        }
        for(int i=1;i<A.length;i++){
            for(int j=m;j>0;j--){
                dp[j]=j>=A[i]&&dp[j-A[i]]?true:dp[j];
            }
        }
        int res=m;
        while(res>0&&!dp[res--]);
        return res+1;
    }
    //给出n个物品的体积A[i]和其价值V[i]，将他们装入一个大小为m的背包，最多能装入的总价值有多大？
    //状态转移方程dp[i][j]前i件物品组成j重量下的最大价值，dp[i][j]=Math.max(dp[i-1][j](不使用i物品),dp[i-1][j-A[i]]+V[i]（使用i物品）)
    public int backPackII(int m, int[] A, int[] V) {
        int[] dp=new int[m+1];
        //初始化使用第一件物品的情况
        if(A[0]<=m){
            dp[A[0]]=V[0];
        }
        for(int i=1;i<A.length;i++){
            for(int j=m;j>0;j--){
                dp[j]=j>=A[i]?Math.max(dp[j],dp[j-A[i]]+V[i]):dp[j];
            }
        }
        int res=0;
        for(int j=1;j<=m;j++){
            res=Math.max(res,dp[j]);
        }
        return res;
    }
}
