package array;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * Created by Dell on 2017-06-09.
 */
public class RotateArray {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(matrix==null){
            return list;
        }
        int row=matrix.length;//行
        int rowBegin=0,rowEnd=row-1;
        int col=matrix[0].length;//列
        int colBegin=0,colEnd=col-1;
        int direct=0;
        while(row!=0&&col!=0){
            switch (direct%4){
                case 0://向右
                    for(int i=colBegin;i<=colEnd;i++){
                        list.add(matrix[rowBegin][i]);
                    }
                    rowBegin++;
                    row--;
                    break;
                case 1://向下
                    for(int i=rowBegin;i<=rowEnd;i++){
                        list.add(matrix[i][colEnd]);
                    }
                    colEnd--;
                    col--;
                    break;
                case 2://向左
                    for(int i=colEnd;i>=colBegin;i--){
                        list.add(matrix[rowEnd][i]);
                    }
                    rowEnd--;
                    row--;
                    break;
                case 3://向上
                    for(int i=rowEnd;i>=rowBegin;i--){
                        list.add(matrix[i][colBegin]);
                    }
                    colBegin++;
                    col--;
                    break;
            }
            direct++;
        }
        return list;
    }
}
