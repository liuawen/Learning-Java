package part12dp;

/**
 * Created by Dell on 2017-07-30.
 */
public class MinCost {
    //c0    插入  c1  删除  c2修改
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        int[][] dp=new int[n+1][m+1];
        //先计算一个修改的最小代价
        int alter=Math.min(c0+c1,c2);
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        for(int i=1;i<=m;i++){//求第一行的代价
            dp[0][i]=c0*i;
        }
        for(int i=1;i<=n;i++){//求第一列的代价
            dp[i][0]=c0*i;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==j){//是否相等，是否要记修改的代价
                    if(a[i-1]!=b[j-1]){
                        dp[i][j]=dp[i-1][j-1]+c2;
                    }
                }else if(j<i){//要多一个删除A的代价
                    dp[i][j]=dp[i-1][j]+c1;
                }else{//大于的时候要多一个删除的代价
                    dp[i][j]=dp[i][j-1]+c1;
                }
            }
        }
        return dp[n][m];
    }
}
