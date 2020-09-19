package jiuzhang.dp;

import java.util.Arrays;

/**
 * Created by Dell on 2017-08-19.
 */
public class PalindromePartitionII {
    public int minCut(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int[] cut=new int[s.length()+1];
        boolean[][] isPalindrome=getisPalindrome(s);
        cut[0]=0;
        for(int i=1;i<=s.length();i++){
            cut[i]=Integer.MAX_VALUE;
            for(int j=1;j<=i;j++){//从最长的串开始判断是否是回文，如果是回文，更新当前切的刀数
                if(isPalindrome[i-j][i-1]&&cut[i-j]!=Integer.MAX_VALUE){
                    cut[i]=Math.min(cut[i],cut[i-j]+1);
                }
            }
        }
        return cut[s.length()]-1;
    }

    private boolean[][] getisPalindrome(String s) {
        boolean[][] isPalindrome=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){//将斜对角线上的赋值为true
            isPalindrome[i][i]=true;
        }
        for(int i=0;i<s.length()-1;i++){//斜对角线右侧第一个赋值
            isPalindrome[i][i+1]=(s.charAt(i)==s.charAt(i+1));
        }

        //沿着斜对角线，将右上角的每一条斜线赋值
        for(int length=2;length<s.length();length++){//回文串的长度依次为2,3，，，
            for(int start=0;start+length<s.length();start++){//依次求每一行
                //值的来源为两头是否相等，除去两头，两头的中间是否是回文串
                isPalindrome[start][start+length]=
                        isPalindrome[start+1][start+length-1] && s.charAt(start)==s.charAt(start+length);
            }
        }
        return isPalindrome;
    }

    //-----------------------------------------------------------------------------------------------------------------
    //尝试用暴力求解，优化为dp
    public int minCutI(String s) {
        int[] res=new int[1];
        res[0]=s.length();
        cuthelp(s,0,res);
        return res[0];
    }
    public void cuthelp(String s,int cut,int[] res){
        if(s.length()==0){
            res[0]=Math.min(res[0],cut);
        }
        for(int i=1;i<=s.length();i++){//开始尝试不同的切割方法
            if(isPalindrome(s.substring(0,i))){
                cuthelp(s.substring(i,s.length()),cut+1,res);
            }
        }
    }
    public boolean isPalindrome(String s){
        int begin=0,end=s.length()-1;
        while(begin<end){
            if(s.charAt(begin)==s.charAt(end)){
                begin++;end--;
            }else{
                return false;
            }
        }
        return true;
    }
    //-----------------------------------------------------------------------------------------------------------------
    //用一维矩阵尝试优化
    public int minCutII(String s) {
        int[] dp=new int[s.length()];
        for(int i=1;i<s.length();i++){
            int min=dp[i-1]+1;//最差的情况
            for(int begin=0;begin<i;begin++){
                if(isPalindrome(s.substring(begin,i+1))){
                    min=Math.min((begin-1)>=0?(dp[begin-1]+1):0,min);
                }
            }
            dp[i]=min;
        }
        Arrays.stream(dp).forEach(i->System.out.print(i+"    "));
        return dp[s.length()-1];
    }


}
