package lintcode.dp;

/**
 * Created by Dell on 2017-09-01.
 */
public class PartitionEqualSubsetSum {
    //分割的也不是这么简单，可能多个元素组合的值相等，背包问题
    public boolean canPartition(int[] nums) {
        long sum=0;int max=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(max,nums[i]);
        }
        if((sum&1)==1){
            return false;
        }
        sum/=2;
        if(max>sum){
            return false;
        }
        //转换成背包问题求解,背包的最大重量为sum/2
        boolean[] dp=new boolean[(int)sum+1];
        dp[0]=true;
        if(nums[0]<=sum){
            dp[nums[0]]=true;
        }
        for(int i=1;i<nums.length;i++){
            for(int j=dp.length-1;j>=nums[i];j--){
                if(!dp[j]){
                    dp[j]=dp[j-nums[i]];
                }
            }
        }
        return dp[(int)sum];
    }
}
