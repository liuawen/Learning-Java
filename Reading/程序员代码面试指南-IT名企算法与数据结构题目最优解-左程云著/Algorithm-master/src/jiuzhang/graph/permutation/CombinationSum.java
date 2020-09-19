package jiuzhang.graph.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Dell on 2017-08-28.
 */
public class CombinationSum {
    //candidates需要排序加去重
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i:candidates){
            set.add(i);
        }
        int[] arr=new int[set.size()];
        int index=0;
        for(int i:set){
            arr[index++]=i;
        }
        Arrays.sort(arr);
        helper(lists,new ArrayList<Integer>(),arr,target,0,0);
        return lists;
    }
    public void helper(List<List<Integer>> lists, ArrayList<Integer> list,int[] candidates,int target,int pos,int sum){
        if(sum>=target){
            if(sum==target){
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=pos;i<candidates.length;i++){
            list.add(candidates[i]);
            helper(lists,list,candidates,target,i,sum+candidates[i]);
            list.remove(list.size()-1);
        }
    }
}
