package jiuzhang.graph.permutation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dell on 2017-08-28.
 */
public class Test {
    public static void main(String[] args){
//        String str="aaa";
        String a="hit",b= "cog";
        Set<String> set=new HashSet<String>();
        String[] strs={"hot","dot","dog","lot","log"};
        for(String i:strs){
            set.add(i);
        }
        new WordLadder().ladderLength(a,b,set);
//        System.out.println(str.substring(1,1));
//        System.out.println(str.substring(1,3));
//        int[] nums={1,2,3};
//        new PermutationsI().permute(nums);
//        List<List<Integer>> lists=new SubSets().subsets(nums);
//        for(List<Integer> list:lists){
//            for(int i:list){
//                System.out.print(i+"    ");
//            }
//            System.out.println();
//        }
    }
}
