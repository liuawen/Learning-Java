package nowCoderClass1.section12;

/**
 * Created by Dell on 2017-06-04.
 */
public class Exchange {

    public int countWays(int[] penny, int n, int aim) {
        if(n==0||aim==0){
            return 0;
        }
        int[][] dp=new int[n][aim+1];
        //初始化第一列
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        //初始化第一行
        for(int j=1;j*penny[0]<=aim;j++){
            dp[0][j*penny[0]]=1;
        }
        //按行初始化
        for(int i=1;i<n;i++){
            dynamicManage(penny,i, aim, dp);
        }
        return dp[n-1][aim];
    }

    private void dynamicManage(int[] penny, int i, int aim, int[][] dp) {
        //依次统计该行每一列的值
        for(int j=1;j<=aim;j++){
            if(j<penny[i]){
                dp[i][j]=dp[i-1][j];
            }else{
                dp[i][j]=dp[i][j-penny[i]]+dp[i-1][j];
            }
        }
    }
}
