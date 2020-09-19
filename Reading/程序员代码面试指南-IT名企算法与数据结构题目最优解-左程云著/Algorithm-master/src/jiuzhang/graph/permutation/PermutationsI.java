package jiuzhang.graph.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列,递归
 * Created by Dell on 2017-08-28.
 */
public class PermutationsI {
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        getAllPermutation(list,new ArrayList<>(),nums);
        return list;
    }
    //使用set时元素的顺序并不是添加进去的顺序
    public void getAllPermutation(List<List<Integer>> list, ArrayList<Integer> set,int[] nums){
        if(set.size()==nums.length){
            list.add(new ArrayList<>(set));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                getAllPermutation(list,set,nums);
                set.remove(nums[i]);
            }
        }
    }
}
