package string;

/**
 * Created by Dell on 2017-06-21.
 */
public class MatchStr {
    /**
     * 模式匹配，。表示任意一个字符，*表示前面的字符可以出现任意次（0次或1次）
     * @param str
     * @param pattern   模式串，匹配串
     * @return
     */
//    public boolean match(char[] str, char[] pattern)
//    {
//
//    }
    /**
     * 匹配 .
     */
    public boolean matchPoint(char[] str,int begin1,int end1,char[] pattern,int begin2,int end2){
        for(;begin1<=end1;){
            if(str[begin1++]!=pattern[begin2++]){
                return false;
            }
        }
        return true;
    }
    /**
     * 匹配 *
     */
//    public boolean matchStar(char[] str,int begin1,char[] pattern,int begin2,int end2){
//
//    }
}
