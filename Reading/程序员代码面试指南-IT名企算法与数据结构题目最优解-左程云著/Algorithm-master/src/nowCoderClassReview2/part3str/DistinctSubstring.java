package part3str;

/**
 * 最长无重复子串，
 * 思想是统计以当前字符结尾情况下的最长的无重复子串，并将之前的字符存起来作为参考，更新begin
 * Created by Dell on 2017-07-23.
 */
public class DistinctSubstring {
    public int longestSubstring(String A, int n) {
        char[] chars=A.toCharArray();
        int[] map=new int[256];//记录每个字符上一次出现的位置
        for(int i=0;i<256;i++){
            map[i]=-1;
        }
        int begin=0;
        int end=0;
        int maxlen=0;
        for(int i=0;i<A.length();i++){//考察截止到i位置的最大子串的长度
            //i位置的字符之前出现过，更新begin到出现的字符之后的一个位置
            begin=Math.max(map[chars[i]]+1, begin);//begin必须选取两者中较大的一个，假设abdbaes这样的字符串，统计时从b开始计算，有可能因为后面的a出现的位置很早，而多计算中间的字符
            end=i;//更新end
            maxlen=Math.max(end-begin+1,maxlen);//更新len
            map[chars[i]]=i;//更新map中该字符的下标
        }
        return maxlen;
    }
}
