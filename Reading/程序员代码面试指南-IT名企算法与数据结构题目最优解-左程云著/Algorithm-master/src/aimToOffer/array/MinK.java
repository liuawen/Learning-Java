package array;


import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 最小的K个数，使用快排的思路，堆排序的思路
 * Created by Dell on 2017-06-11.
 */
public class MinK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list=new ArrayList<Integer>();
        if(k==0||input.length<k)
            return list;
        TreeSet<Integer> set=new TreeSet<Integer>();//first是最小，last是最大
        int index=0;
        //将前K个数装入
        while (index<k){
            set.add(input[index]);
            index++;
        }
        for(;index<input.length;index++){
            if(input[index]<set.last()){
                set.remove(set.last());
                set.add(input[index]);
            }
        }
        //将set装入list中
        while (set.size()>0){
            list.add(set.first());
            set.remove(set.first());
        }
        return list;
    }
}
