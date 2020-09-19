package lintcode.dp;

/**不同的路径
 * Created by Dell on 2017-08-30.
 */
public class UniquePath {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];

        //第一行
        for(int j=0;j<n;j++){
            if(obstacleGrid[0][j]==1){
                for(;j<n;j++){
                    dp[0][j]=0;
                }
                break;
            }
            dp[0][j]=1;
        }
        //第一列
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1){
                for(;i<n;i++){
                    dp[i][0]=0;
                }
                break;
            }
            dp[i][0]=1;
        }
        //剩余的
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==0){
                    if(obstacleGrid[i-1][j]==0){
                        dp[i][j]+=dp[i-1][j];
                    }
                    if(obstacleGrid[i][j-1]==0){
                        dp[i][j]+=dp[i][j-1];
                    }
                }
            }
        }
        return dp[m-1][n-1];

    }
}
