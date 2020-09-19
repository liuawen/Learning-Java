package nowCoderClass1.section12;

/**
 * Created by Dell on 2017-06-04.
 */
public class MinimumPath {
    public int getMin(int[][] map, int n, int m) {
        if(n==0||m==0){
            return 0;
        }
        int count=0;
        int min=m>n?n:m;
        //计算第一行
        System.out.println((count)+" 行  :   列  ");
        for(int j=count+1;j<m;j++){
            map[count][j]+=map[count][j-1];
            System.out.print(j+"   ");
        }
        System.out.println((count)+" 列  :   行  ");
        //计算第一列
        for(int i=count+1;i<n;i++){
            map[i][count]+=map[i-1][count];
            System.out.print(i+"   ");
        }

        count++;
        while(count<min){
            //计算一行
            System.out.println(count+" 行  :   列  ");
            for(int j=count;j<m;j++){
                map[count][j]+=map[count][j-1]<map[count-1][j]?map[count][j-1]:map[count-1][j];
                System.out.print(j+"   ");
            }
            System.out.println((count)+" 列  :   行  ");
            //计算一列
            for(int i=count+1;i<n;i++){
                map[i][count]+=map[i-1][count]<map[i][count-1]?map[i-1][count]:map[i][count-1];
                System.out.print(i+"   ");
            }

            count++;
        }
        //剩余部分值计算会导致计算结果不对，即使行列不相同，但是所有的值都会计算一遍
        return map[n-1][m-1];
    }
}
