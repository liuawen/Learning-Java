package jiuzhang.dp;

import java.util.Set;

/**
 * Created by Dell on 2017-08-20.
 */
public class CutWord {
    public boolean wordBreak(String s, Set<String> dict) {
        int dicMaxLen=0;
        for(String l:dict){
            dicMaxLen=Math.max(l.length(),dicMaxLen);
        }
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<s.length()+1;i++ ){
            for(int j=1;j<=Math.min(dicMaxLen,i);j++){
                if(dp[i-j]) {
                    dp[i] = dict.contains(s.substring(i - j, i));
                }
                if(dp[i])
                    break;
            }
        }
        return dp[s.length()];
    }
}
