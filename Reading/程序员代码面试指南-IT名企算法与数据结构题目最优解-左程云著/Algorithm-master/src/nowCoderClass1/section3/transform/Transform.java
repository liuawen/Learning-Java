package nowCoderClass1.section3.transform;

/**
 *
    对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
    给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
     测试样例：
    "abc",3,"bca",3
    返回：true


 * Created by Dell on 2017-05-07.
 */
public class Transform {
    /**
     * 使用哈希表做字频统计，
     * @param A
     * @param lena
     * @param B
     * @param lenb
     * @return
     */
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        // write code here
        if(lena!=lenb||A==null||B==null)
            return false;
        boolean result=false;
        //建立一个set，统计字频，
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        int[] set=new int[256];
        //将a中的字符对应的频次加1
        for(int i=0;i<a.length;i++){
            set[a[i]]++;
        }
        //将b中的字符对应的频次-1,如果-的时候发现字频为0，返回false
        for(int i=0;i<b.length;i++){
            if(set[b[i]]--==0)
                return false;
        }
        return true;
    }
}
