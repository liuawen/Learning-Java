package jiuzhang.dp;

/**
 * Created by Dell on 2017-08-20.
 */
public class BackPackVI {
    public int backPackVI(int[] nums, int target) {
        // Write your code here
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j]<=i){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
