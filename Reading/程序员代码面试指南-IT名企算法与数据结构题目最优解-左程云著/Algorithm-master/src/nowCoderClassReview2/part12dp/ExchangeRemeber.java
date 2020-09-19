package part12dp;

/**
 * Created by Dell on 2017-07-29.
 */
public class ExchangeRemeber {
    public int countWays(int[] penny, int n, int aim) {
        int[][] dp=new int[n][aim+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]=-1;
            }
        }
        return remind(dp,penny,0,aim);
    }
    public int remind(int[][] dp,int[] penny,int index,int aim){
        int count=0;
        if(aim==0){
            count++;
        }else{
            int res=0;
            for(int i=0;i<=aim/penny[index];i++){//使用index类型的货币，可以有0-aim/penny[index]种
                int need=aim-penny[index]*i;
                if(index+1<penny.length){
                    if(dp[index+1][need]==-1){
                        res+=remind(dp,penny,index+1,aim-penny[index]*i);//使用i个index类型货币，剩下的货币要组成的钱数
                    }else{
                        res+=dp[index+1][need];
                    }
                }else{
                    if(need==0) {
                        res++;
                    }
                }
            }
            //计算完之后将结果更新到dp中，以备下次使用
            dp[index][aim]=res;
            count+=res;
        }
        return count;
    }
}
