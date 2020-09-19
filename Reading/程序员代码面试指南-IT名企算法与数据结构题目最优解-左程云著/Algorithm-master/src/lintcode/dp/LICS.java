package lintcode.dp;

/**
 * 最长上升连续子序列
 * Created by Dell on 2017-08-29.
 */
public class LICS {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int maxLeft=1,curleft=1;
        for(int i=1;i<A.length;i++){
                curleft=A[i]>A[i-1]?curleft+1:1;
                maxLeft=Math.max(maxLeft,curleft);
        }
        int maxRight=1,curright=1;
        for(int i=A.length-2;i>=0;i--){
                curright=A[i]>A[i+1]?curright+1:1;
                maxRight=Math.max(maxRight,curright);
        }
        return Math.max(maxLeft,maxRight);
    }
}
