package part12dp;

/**
 * Created by Dell on 2017-07-29.
 */
public class ExchangeReWrite {

    public int countWays(int[] penny, int n, int aim) {
        int[][] dp=new int[n+1][aim+1];//n+1存储
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]=-1;
            }
        }
        return search(dp,penny,0,aim);
    }
    public int search(int[][] dp,int[] penny,int index,int aim){
        int count=0;
        if(aim==0){
            count+=1;
        }else{
            if(index<penny.length) {
                for (int i = 0; i <= aim / penny[index]; i++) {
                    int need = aim - penny[index] * i;
                    if (dp[index + 1][need] == -1) {
                        count += search(dp, penny, index + 1, need);
                    } else {
                        count += dp[index + 1][need];
                    }
                }
            }
        }
        dp[index][aim]=count;
        return count;
    }
}
