package part12dp;

/**
 * 在记忆搜索的方式上，将搜索路径确定下来，从基础的开始，逐步推出复杂的
 * Created by Dell on 2017-07-30.
 */
public class ExchangeDp {
    public int countWays(int[] penny, int n, int aim) {
        int[][] dp=new int[n][aim+1];
        //将第一列初始化为1
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        //初始化第一行
        for(int i=1;i<aim+1;i++){
            if(i%penny[0]==0){
                dp[0][i]=1;
            }
        }
        //求解剩余每一行
        for(int i=1;i<n;i++){//控制当前行
            for(int j=1;j<aim+1;j++){//控制每一列
                if(penny[i]>j)
                    dp[i][j]=dp[i-1][j];//等于上一行
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-penny[i]];//上一行+左边可参考的
            }
        }
//        for(int i=0;i<n;i++){//控制当前行
//            System.out.println("    ");
//            for(int j=0;j<aim+1;j++){//控制每一列
//                System.out.print(dp[i][j]+"     ");
//            }
//        }

        return dp[n-1][aim];
    }
}
