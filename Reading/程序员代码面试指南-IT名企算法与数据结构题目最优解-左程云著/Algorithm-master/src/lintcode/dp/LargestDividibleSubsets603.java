package lintcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dell on 2017-08-31.
 */
public class LargestDividibleSubsets603 {
    //返回最大的可整除的子集
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // Write your code here
        List<Integer> list=new ArrayList<Integer>();
        if(nums==null||nums.length==0)
            return list;
        Arrays.sort(nums);
        int[] dp=new int[nums.length];//dp数组中记录前一个可以整除元素的下标
        int[] count=new int[nums.length];//记录以每个元素结尾的子集的长度
//        dp[0]=-1;
        for(int i=0;i<nums.length;i++){//初始化
            dp[i]=-1;
        }
        for(int i=1;i<nums.length;i++){//dp
            for(int j=i-1;j>=0;j--) {
                if(nums[i]%nums[j]==0){
                    dp[i]=j;break;
                }
            }
        }
        int maxIndex=0;
        for(int i=0;i<nums.length;i++){//count
            if(dp[i]==-1){
                count[i]=1;
            }else{
                count[i]=count[dp[i]]+1;
            }
            if(count[i]>count[maxIndex]){
                maxIndex=i;
            }
        }
        int[] res=new int[count[maxIndex]];
        int i=res.length-1;
        while(i>=0){
            res[i--]=nums[maxIndex];
            maxIndex=dp[maxIndex];
        }
        for(int c=0;c<res.length;c++){
            list.add(res[c]);
        }
        Arrays.stream(dp).forEach(k->System.out.print(k+"   "));
        System.out.println();
        Arrays.stream(count).forEach(k->System.out.print(k+"   "));
        System.out.println();
        Arrays.stream(res).forEach(k->System.out.print(k+"   "));
        System.out.println();

        return list;
    }

}
