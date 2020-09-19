package nowCoderClass1.section14.test;

/**
 * 最长无重复字符子串
 * Created by Dell on 2017-06-20.
 */
public class DistinctSubstring {
    public int longestSubstring(String A, int n) {
        if(A==""||n==0)
            return 0;
        // write code here
        char[] a=A.toCharArray();
        int[] count=new int[256];
        for(int i=0;i<count.length;i++){
            count[i]=-1;
        }
        int len = -1,pre=-1;
        int cur=-1;//维护当前的长度
        for(int i=0;i<n;i++) {
            pre = Math.max(count[a[i]], pre);//前
            cur=i-pre;
            len = Math.max(cur,len);
            count[a[i]]=i;
        }
        return len;
    }
}
