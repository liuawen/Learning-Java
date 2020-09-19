package lintcode.dp;

/**
 * 交叉字符串，
 * Created by Dell on 2017-08-29.
 */
public class InterLeave {
    //s3是否由s1，s2组成
    //dp矩阵由s1，s2，加上“”组成
    //dp[i][j]表示使用前i，j个字符能否构成s3
    //状态转移方程是
    public boolean isInterleave(String s1, String s2, String s3) {
        //s1或s2可能是空串
        if(s1==null||s1.equals("")){
            return s3.equals(s2);
        }
        if(s2==null||s2.equals("")){
            return s3.equals(s1);
        }
        //加上对长度的校验，否则后面的计算会数组越界
        if(s3.length()!=(s1.length()+s2.length())){
            return false;
        }

        // write your code here
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        char[] c3=s3.toCharArray();
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        //初始化第一行
        dp[0][0]=true;
        for(int j=1;j<dp[0].length;j++){
            if(dp[0][j-1]){
                dp[0][j]=c3[j-1]==c2[j-1];
            }
        }
        //初始化第一列
        for(int i=1;i<dp.length;i++){
            if(dp[i-1][0]){
                dp[i][0]=c3[i-1]==c1[i-1];
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //dp[i][j]值来自上方或左方
                if(dp[i-1][j]||dp[i][j-1]) {
                    dp[i][j] = c3[i + j - 1] == (dp[i - 1][j] ? c1[i - 1] : c2[j - 1]);//状态转移方程,这错了，因为dp[i][j-1]可能为false
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

//    for(int i=0;i<dp.length;i++){
//        for(int j=0;j<dp[0].length;j++){
//            System.out.print(dp[i][j]+"    ");
//        }
//        System.out.println();
//    }
}
