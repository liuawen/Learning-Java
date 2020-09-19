package lintcode.dp;

import java.util.List;

/**
 * Created by Dell on 2017-08-29.
 */
public class MinAdjustCost {
    //target为两数之间的差距
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        long[][] dp=new long[A.size()][101];
        //初始化第一行
        for(int j=0;j<101;j++){
            dp[0][j]=Math.abs(j-A.get(0));
        }
        int begin=0,end=0;int min=0;
        for(int i=1;i<A.size();i++){
            for(int j=0;j<101;j++){
                begin=j-target;end=j+target;
                if(begin<0){begin=0;}
                if(end>100){end=100;}
                min=begin;
                for(int k=begin+1;k<=end;k++){
                    if(dp[i-1][k]<dp[i-1][min]){
                        min=k;
                    }
                }
                //前面是在以j结尾的情况下，上一个结尾的中挑选调整代价最小的
                dp[i][j]=dp[i-1][min]+Math.abs(A.get(i)-j);
            }
        }
        //结果是最后一行中最小的一个
        long res=dp[A.size()-1][0];
        for(int j=1;j<101;j++){
            res=Math.min(res,dp[A.size()-1][j]);
        }
        return (int)res;

    }
}
