package jiuzhang.graph.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dell on 2017-08-28.
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        getSubSets(lists,new ArrayList<Integer>(),nums,0);
        return lists;

    }
    public void getSubSets(List<List<Integer>> lists, ArrayList<Integer> list,int[] nums,int index){
//        if(index==nums.length){
            lists.add(new ArrayList<Integer>(list));
//            return;
//        }
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            getSubSets(lists,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
