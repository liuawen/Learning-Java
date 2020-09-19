package nowCoderClass1.section12;

/**
 * Created by Dell on 2017-06-05.
 */
public class Backpack {
//    public int maxValue(int[] w, int[] v, int n, int cap) {
//        //下标表示前面的物品，
//        int[] dp=new int[n+1];//存放i-1件物品的最大价值
//        for(int i=1;i<=n;i++){
//            int value=w[i-1]*v[i-1];
//            if(value<cap){
//                //比较放入该物品的价值，不放入该物品的价值
//                int yes=value+dp[i-1];
//                int no=dp[i-1];
//                dp[i]=yes
//            }
//        }
//    }
//    public int maxValue(int[] w, int[] v, int n, int cap) {
//        // dp[x][y]表示物品数量为x,重量不超过y时背包中的总价值
//        //两种情况：1.将x物品不加入到背包中，那么前x-1件物品的总重量不应该超过y。dp[x][y] = dp[x-1][y]
//        //2.将x物品加入到背包中，那么前x-1前物品的总重量不应该超过y-w(x),因此dp[x][y] = dp[x-1][y-w(x)]+v(x);
//        int[] dp = new int[cap+1];
//
//        for(int i=0;i<n;i++){//控制物品的数量
//            for(int j=cap;j>=w[i];j--){//空背包中不能超重
//                dp[j] = dp[j]>=dp[j-w[i]]+v[i]?dp[j]:dp[j-w[i]]+v[i];//选取j加入书包与j不加入书包的较大值
//            }
//        }
//
//        return dp[cap];//返回数组的最后一位即是最大总价值
//    }
    public int maxValue(int[] w, int[] v, int n, int cap) {
        int[] dp=new int[cap+1];//用cap+1是要存储重量为0时的价值，避免越界
        for(int i=0;i<n;i++){
            //思考为什么是从后往前，而不是从前往后呢
            //如果从前往后计算，可能会将一件物品的价值重复加入最大价值中
            for(int j=cap;j>=w[i];j--){
                dp[j]=dp[j]>dp[j-w[i]]+v[i]?dp[j]:dp[j-w[i]]+v[i];
            }
        }
        return dp[cap];
    }

}
