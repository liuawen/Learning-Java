package jiuzhang.dp;

/**
 * Created by Dell on 2017-08-19.
 */
public class triangle {
    //使用动态规划，自底向上
    public int minimumTotal1(int[][] triangle) {
        int[] dp=new int[triangle[triangle.length-1].length];
        for(int i=0;i<dp.length;i++){
            dp[i]=triangle[triangle.length-1][i];
        }
        for(int i=triangle.length-2;i>=0;i--){
            for(int j=0;j<triangle[i].length;j++){
                dp[j]=triangle[i][j]+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
    //使用动态规划，自顶向下，为方便，直接在元数据上修改
    public int minimumTotal(int[][] triangle) {
        for(int i=1;i<triangle.length;i++){
            triangle[i][0]+=triangle[i-1][0];
            for(int j=1;j<triangle[i].length-1;j++){
                triangle[i][j]+=Math.min(triangle[i-1][j-1],triangle[i-1][j]);
            }
            triangle[i][triangle[i].length-1]+=triangle[i-1][triangle[i].length-2];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<triangle[triangle.length-1].length;i++){
            if(triangle[triangle.length-1][i]<min){
                min=triangle[triangle.length-1][i];
            }
        }
        return min;
    }

}
