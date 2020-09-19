package lintcode.dp;

/**
 * Created by Dell on 2017-09-01.
 */
public class BackpackIII {
    //n件物品，每件物品可使用多次，能否组成K
    //在能组成的可能性中，物品数最小是多少


    //----------------bug---------该程序有问题---------bug-----------------------
    public int backPackII(int[] A,int K) {//用宽度优先搜索的方式
        boolean[] dp=new boolean[K+1];

        //初始化dp状态
        dp[0]=true;
        for(int j=0;j<A.length;j++){
            if(A[j]==K){
                return 1;
            }else if(A[j]<K){
                dp[A[j]]=true;
            }
        }
        int res=2;
        while(res<=K) {
            for (int i = 1; i <= K; i++) {
                if (dp[i]) {
                    for (int j = 0; j < A.length; j++) {
                        if (i + A[j] == K) {
                            return res;
                        } else if (i + A[j] < K) {
                            dp[i + A[j]] = true;
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }

}
