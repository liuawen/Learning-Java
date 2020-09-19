package lintcode.dp;

/**
 * Created by Dell on 2017-08-31.
 */
public class Decode_Ways512 {
    public int numDecodings(String s) {
        // write your code here
        if(s==null||s.length()==0||s.equals("")){
            return 0;
        }
        char[] c=s.toCharArray();
        //类似斐波那契数列，但是有限制条件，选择两个时，必须10-26，一个时不能为0
        int[] dp=new int[s.length()+1];
        dp[0]=1;//初始化为1是因为如果前两个字符可以组合时，也算一种情况，如果初始化为0，‘12’dp的结果为1，而不是2
        if(c[0]!='0')dp[1]=1;
        for(int i=1;i<s.length();i++){
            if(c[i]!='0'){
                dp[i+1]+=dp[i];//可以单独组合
            }
            if((c[i-1]=='1'||(c[i-1]=='2'&&c[i]<'7'))){
                dp[i+1]+=dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
