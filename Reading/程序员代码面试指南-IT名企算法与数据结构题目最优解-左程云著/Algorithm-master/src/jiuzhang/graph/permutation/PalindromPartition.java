package jiuzhang.graph.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell on 2017-08-28.
 */
public class PalindromPartition {
    private boolean isPalindrom(String s){
        int front=0,tail=s.length()-1;
        while (front<tail){
            if(s.charAt(front++)!=s.charAt(tail--)){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> lists=new ArrayList<List<String>>();
        if(s==null||s.equals("")){
            return lists;
        }
        getPartitionHelper(lists,new ArrayList<String>(),s,0);
        return lists;
    }
    public void getPartitionHelper(List<List<String>> lists, ArrayList<String> list,String s,int index){
        if(index==s.length()){
            lists.add(new ArrayList<String>(list));
            return;
        }
        String str="";
        for(int i=index;i<s.length();i++){//每次是不是index---i
            str=s.substring(index,i+1);
            if(isPalindrom(str)){
                list.add(str);
                getPartitionHelper(lists, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
