package jiuzhang.dp;

/**
 * Created by Dell on 2017-08-20.
 */
public class MaxSquare {
    //最大正方形
    public int maxSquare(int[][] matrix) {
        int temp=0,max=0;
        if(matrix.length==1||matrix[0].length==1){
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[i].length;j++){
                    if(matrix[i][j]==1){
                        return 1;
                    }
                }
            }
            return 0;
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j]==1&&(temp=matrix[i-1][j-1])!=0){
                    //选出三个中最小的一个
                    temp=Math.min(temp,matrix[i-1][j]);
                    temp=Math.min(temp,matrix[i][j-1]);
                    matrix[i][j]=temp+1;
                }
                max=Math.max(max,matrix[i][j]);
            }
        }
        return max*max;
    }
}
