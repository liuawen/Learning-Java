package jiuzhang.graph.permutation;

import java.util.Set;

/**
 * Created by Dell on 2017-08-28.
 */
public class WordLadder {
    //TODO DFS BFS 记得练习
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        int[] res=new int[2];//0记录最终结果，1记录当前步数
        res[0]=Integer.MAX_VALUE;res[1]=1;
        helper(start,end,dict,res);
        return res[0]==Integer.MAX_VALUE?0:res[0];
    }
    public void helper(String cur,String end,Set<String> dict,int[] res){
        if(oneDifferent(cur,end)){
            res[0]=Math.min(res[1]+1,res[0]);
            return;
        }
        for(String str:dict){
            if(oneDifferent(cur,str)){
                res[1]+=1;
                dict.remove(str);
                helper(str,end,dict,res);
                dict.add(str);
            }
        }
    }
    public boolean oneDifferent(String str1,String str2){
        for(int begin=0,end=str1.length();begin<end;begin++){
            if(str1.charAt(begin)!=str2.charAt(begin)){
                return str1.substring(begin+1).equals(str2.substring(begin+1));
            }
        }
        return true;
    }
}
