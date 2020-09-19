package jiuzhang.graph.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2017-08-28.
 */
public class UniqueSubSets {
    /**
     * 求子集，子集中有重复的元素，采用之前的解法有重复的解
     * 剪枝方法：重复的元素中，如果前面的不取，则后面的不取
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0){
            return lists;
        }
        getSubSets(lists,new ArrayList<Integer>(),nums,0);
        return lists;
    }
    private void getSubSets(List<List<Integer>> lists, ArrayList<Integer> list,int[] nums,int index){

        lists.add(new ArrayList<Integer>(list));
        for(int i=index;i<nums.length;i++){
            if(i!=index&&nums[i]==nums[i-1]){//i不等于index，就代表取了第一个，后面相同的就不取
                continue;
            }
            list.add(nums[i]);
            getSubSets(lists,list,nums,i+1);
            list.remove(list.size()-1);
//            if(i+1<nums.length&&nums[i]==nums[i+1]){
//                break;//不一定是终止所有循环，可能要跳到后面不重复的元素
//            }
        }
    }
}
