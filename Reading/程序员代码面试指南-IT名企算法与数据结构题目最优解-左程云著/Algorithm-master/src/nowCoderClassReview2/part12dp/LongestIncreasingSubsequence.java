package part12dp;

/**
 * Created by Dell on 2017-07-30.
 */
public class LongestIncreasingSubsequence {
    /**
     * 求最长递增子序列的长度，从前到后，依次计算以i结尾的情况下的最大长度，后面的计算时可以依赖于前面已经统计出来的结果
     * @param A
     * @param n
     * @return
     */
    public int getLIS(int[] A, int n) {
        if(n<2){
            return n;
        }
        int[] dp=new int[n];
        int max=0;//
        for(int i=0;i<n;i++){
            dp[i]=1+getMaxSub(A,i,dp);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public int getMaxSub(int[] A,int index,int[] dp){
        int max=0;
        int num=A[index];index--;
        while(index>=0){
            if(A[index]<num){
                max=Math.max(dp[index],max);
            }
            index--;
        }
        return max;
    }
}
