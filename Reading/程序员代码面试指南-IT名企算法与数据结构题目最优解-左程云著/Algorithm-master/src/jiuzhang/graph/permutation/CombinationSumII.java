package jiuzhang.graph.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dell on 2017-08-28.
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        Arrays.sort(num);
        helper(lists,new ArrayList<Integer>(),num,target,0,0);
        return lists;
    }
    public void helper(List<List<Integer>> lists, ArrayList<Integer> list,int[] candidates,int target,int pos,int sum){
        if(sum>=target){
            if(sum==target){
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=pos;i<candidates.length;i++){//有相同的数字，不选第一个，也不能选第二个
            if(i!=pos&&candidates[i]==candidates[i-1]){
                continue;
            }
            list.add(candidates[i]);
            helper(lists,list,candidates,target,i,sum+candidates[i]);
            list.remove(list.size()-1);
        }
    }
}
