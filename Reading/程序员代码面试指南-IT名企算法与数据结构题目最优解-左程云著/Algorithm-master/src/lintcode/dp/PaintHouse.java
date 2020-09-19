package lintcode.dp;

/**
 * Created by Dell on 2017-09-01.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        for(int i=1;i<costs.length;i++){
            for(int j=0;j<costs[0].length;j++){//选择出费用最低的那种
                int min=Math.min(costs[i-1][j+1%3],costs[i-1][j+2%3]);
                costs[i][j]+=min;
            }
        }
        return Math.min(costs[costs.length-1][0],Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
    }
}
