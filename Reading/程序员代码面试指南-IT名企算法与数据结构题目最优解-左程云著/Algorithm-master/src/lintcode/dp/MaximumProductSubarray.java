package lintcode.dp;

/**
 * 乘积最大连续子序列
 * Created by Dell on 2017-09-01.
 */
public class MaximumProductSubarray {
    public int maxProductII(int[] nums) {
        // write your code here
        if(nums==null||nums.length==0){
            return 0;
        }
        int pos=nums[0],neg=nums[0];//记录以该点结尾的子序列的乘积，要么是该点，要么是该点乘以该点前一个
        int max=pos;//由max记录每次的最大值
        for(int i=1;i<nums.length;i++){
            int tempPosMax = pos;//以上个点结尾的最大值
            int tempNegMax = neg;//以上个点结尾的最小值
            pos = Math.max(nums[i],Math.max(nums[i]*tempPosMax,nums[i]*tempNegMax));//pos为当前点或者当前点*最大或最小值中较大的一个
            neg = Math.min(nums[i],Math.min(nums[i]*tempPosMax,nums[i]*tempNegMax));//neg为
            max = Math.max(max,pos);
        }
        return max;
    }
    //乘积最大连续子序列
    public int maxProduct(int[] nums) {
        // write your code here
        int max=nums[0];
        int min=nums[0];
        int res=max;
        for(int i=1;i<nums.length;i++){
            int beforeMax=max,beforeMin=min;
            max=Math.max(Math.max(beforeMax*nums[i],beforeMin*nums[i]),nums[i]);//三选一，当前的，最小的乘当前的，最大的乘当前的
            min=Math.min(Math.min(nums[i]*beforeMax,nums[i]*beforeMin),nums[i]);
            res=Math.max(max,res);
        }
        return res;
    }

}
