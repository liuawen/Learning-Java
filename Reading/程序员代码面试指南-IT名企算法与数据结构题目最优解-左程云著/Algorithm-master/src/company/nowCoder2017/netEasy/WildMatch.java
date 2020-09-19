package company.nowCoder2017.netEasy;

/**
 * 字符串匹配
 * Created by Dell on 2017-08-16.
 */
public class WildMatch {
    public boolean chkWildMatch(String A, int lena, String B, int lenb) {
        // write code here
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        boolean[][] dp=new boolean[lenb][lena];
        //第一行
        dp[0][0]=(b[0]=='.')?true:(b[0]==a[0]);
        //第一列
        for (int i=1;i<lenb;i++){
            if(dp[i-1][0]){
                dp[i][0]=b[i]=='.'||b[i]=='*';
            }
        }
        for(int i=1;i<lenb;i++){
            char cur=b[i];
            if(cur=='*'){
                for (int j=1;j<lena;j++){
                        dp[i][j]=dp[i][j-1]||dp[i-1][j-1];
                }
            }else{
                if(cur=='.'){
                    for (int j=1;j<lena;j++){
                        if(dp[i-1][j-1]) {
                            dp[i][j] = true;
                        }
                    }
                }else{
                    for (int j=1;j<lena;j++){
                        if(dp[i-1][j-1]) {
                            dp[i][j]=cur==a[j];
                        }
                    }
                }
            }
        }
        for (int i=0;i<lenb;i++){
            for(int j=0;j<lena;j++){
                System.out.print(dp[i][j]+"    ");
            }
            System.out.println();
        }

        return dp[lenb-1][lena-1];
    }
}
