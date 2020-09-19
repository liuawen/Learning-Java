package codingInterviewGuide.part4dp;

/**最长公共子串，得用dp去做
 * Created by Dell on 2017-08-10.
 */
public class LongestSubstring {
    public int findLongest2(String A, int n, String B, int m) {
        int[][] dp=new int[n+1][m+1];
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        int len=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i]==b[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                    len=Math.max(len,dp[i+1][j+1]);
                }
            }
        }
        return len;
    }
    public int findLongest(String A, int n, String B, int m) {
//        int[][] dp=new int[n+1][m+1];
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        int len=0,cura=0,curb=0,curlen=0;//按照斜线计算，可将空间压缩至O(1)
        //将矩阵上半区统计
            for(int j=0;j<m+n;j++){
                if(j<n){
                    cura=j;curb=0;
                }else{
                    cura=0;curb=j-n;
                }
                curlen=0;
                while(cura<n&&curb<m){//从a串第一个字符开始比较，直至其中一个字符超出
                    if(a[cura]==b[curb]){
                        curlen+=1;len=Math.max(len,curlen);
                    }else{
                        curlen=0;
                    }cura++;curb++;
                }
            }
        return len;
    }
}
