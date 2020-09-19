package nowCoderClass1.sorted;

/**
 * 现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。

 给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，请返回一个bool值，代表矩阵中是否存在x。所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
 测试样例：

 [[1,2,3],[4,5,6],[7,8,9]],3,3,10
 * Created by Dell on 2017-05-06.
 */
public class Finder {
    /**
     * 从右上角开始排查，逐步缩小范围
     * @param mat
     * @param n 行号
     * @param m 列号
     * @param x 要查找的值
     * @return
     */
    public boolean findX(int[][] mat, int n, int m, int x) {
        int right=m-1;
        int top=0;
        while(right>=0&&top<=n-1){
            if(mat[top][right]==x){//找到
                return true;
            }else{
                if(mat[top][right]<x){//要找的数大，大往下找
                    top++;
                }else{//要找的数大小，小往左找
                    right--;
                }
            }
        }
        return false;
    }
}
