package codingInterviewGuide.part4dp;

/**
 * Created by Dell on 2017-08-10.
 */
public class MinCost {
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<m+1;i++){//第一行
            dp[0][i]=dp[0][i-1]+c0;
        }
        for(int i=1;i<n+1;i++){//第一列
            dp[i][0]=dp[i-1][0]+c1;
        }
        for(int i=0;i<n;i++){//每一行
            for(int j=0;j<m;j++){//一行中的每一个元素
                int temp=0,left=0,top=0;
                dp[i+1][j+1]=dp[i][j];
                if(a[i]!=b[j]){
                    dp[i+1][j+1]+=c2;
                }
                //衡量从左边或上边变过来和斜线，选择最小的
                dp[i+1][j+1]=Math.min(dp[i+1][j+1],dp[i+1][j]+c0);
                dp[i+1][j+1]=Math.min(dp[i+1][j+1],dp[i][j+1]+c1);
            }
        }
        return dp[n][m];
    }
}
