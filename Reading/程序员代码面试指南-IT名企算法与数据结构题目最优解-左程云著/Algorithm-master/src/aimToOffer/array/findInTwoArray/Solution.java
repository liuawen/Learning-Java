package array.findInTwoArray;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by Dell on 2017-06-08.
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        //对空的判断
        if(array==null)
            return false;
        //从右上角或者左下角开始判断，每次可缩小范围一行或一列
        int row=array.length,col=array[0].length;
        //从右上角开始寻找，一定要注意，只使用一个for循环即可，如使用两个，内层循环可能还需要加入外层循环是否越界的判断
        for(int i=0,j=col-1;i<row&&j>=0;)
            if(target==array[i][j])
                return true;
            else
                if(target<array[i][j])
                    j--;
                else
                    i++;
        return false;
    }
    public boolean Find(int[][] array,int target) {
        int len = array.length-1;
        int i = 0;
        while((len >= 0)&& (i < array[0].length)){
            if(array[len][i] > target){
                len--;
            }else if(array[len][i] < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
