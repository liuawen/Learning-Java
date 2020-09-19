package nowCoderClass1.section12;

/**
 * 求最长递增子序列
 * Created by Dell on 2017-06-04.
 */
public class LongestIncreasingSubsequence {
    /**
     * 大问题分成小问题，如果求以i结尾的最长序列，找到前一个比其小的值的最长序列值，在其基础上+1
     * 利用了子问题的解求解大问题
     * @param A
     * @param n
     * @return
     */
    public int getLIS(int[] A, int n) {
        if(n==1) {
            return n;
        }
        int[] dp=new int[n];
        dp[0]=1;
        int max=1;
        for(int i=1;i<n;i++){
            dp[i]=findMax(A,i,dp)+1;
            max=dp[i]>max?dp[i]:max;
        }
//
//        for(int i=0;i<n;i++){
//            System.out.print(dp[i]+" ");
//        }
        return max;
    }
    /**
     * 求dp[i]时，在dp[0...n-1]中存在比A[i]小的数，从这些数中选出最大的
     */
    public int findMax(int[] A,int n,int[] dp){
        int max=0;
        for(int i=n-1;i>=0;i--){
            if(A[i]<A[n])
                max=dp[i]>max?dp[i]:max;
        }
        return max;
    }
}
