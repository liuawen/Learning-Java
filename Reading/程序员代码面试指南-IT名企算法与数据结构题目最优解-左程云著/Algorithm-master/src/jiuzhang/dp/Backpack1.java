package jiuzhang.dp;

/**
 * Created by Dell on 2017-08-20.
 */
public class Backpack1 {
    public int backPack(int m, int[] A) {
        // write your code here
        boolean[] dp=new boolean[m+1];
        //初始化第一行
        if(A[0]<=m) {
            dp[A[0]] = true;
        }
        dp[0]=true;
        for(int i=1;i<A.length;i++){
            for(int j=m;j>=A[i];j--){
                dp[j]=dp[j]||dp[j-A[i]];
            }
        }
        int res=m;
        while(res>=0&&!dp[res--]);
        return res+1;
    }
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int[] dp=new int[m+1];
        int sum=0;
        if(A[0]<=m) {
            dp[A[0]] = V[0];
            sum+=A[0];
        }

        for(int i=1;i<A.length;i++){
            sum+=A[i];
            for(int j=Math.min(sum,m);j>A[i];j--){//使用1张货币或不使用该货币
                dp[j]=dp[j-A[i]]==0?dp[j]:Math.max(dp[j],dp[j-A[i]]+V[i]);
            }
            dp[A[i]]=Math.max(dp[A[i]],V[i]);//注意不使用其他货币的情况
        }

        for(int i=50;i<=m;i++){
            System.out.print(dp[i]+"  ");
        }
        System.out.println();

        int max=0;
        while(m>=0){
            if(dp[m]>max){
                max=dp[m];
            }
            m--;
        }
        return max;
    }
}
