package array;

import java.util.ArrayList;

/**
 * Created by Dell on 2017-06-13.
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(array.length<2)
            return list;
        int start=0,end=array.length-1;
        while(start<end){
            if(array[start]+array[end]==sum){
                list.add(array[start]);
                list.add(array[end]);
                return list;
            }else{
                if(array[start]+array[end]<sum){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return list;
    }
}
