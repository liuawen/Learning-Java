package nowCoderClass1.section1.rotateWord;

/**
 * 最优解时间复杂度为O(n)
 * 判断str1与str2是否长度相等，相等则生成str1+str1的长字符串
 * 使用KMP算法判断长字符串是否包含str2
 *
 * Created by Dell on 2017-04-13.
 */
public class RotateString {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if(lena!=lenb)
            return false;
        String C=A+A;
        if(C.contains(B)){
            return true;
        }else{
            return false;
        }
    }




}
