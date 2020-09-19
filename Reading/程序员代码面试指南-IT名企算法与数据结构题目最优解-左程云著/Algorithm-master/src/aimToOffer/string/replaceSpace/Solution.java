package string.replaceSpace;

/**
 * Created by Dell on 2017-06-08.
 */
public class Solution {
    //setCharAt可使StringBuffer像数组一样操作
//    public String replaceSpace(char[] str,int n) {
//
//    }
//    public String replaceSpace(StringBuffer str) {
//        int len=str.length();
//        int count=0;
//        for(int i=0;i<len;i++){
//            if(str.charAt(i)==' ')
//                count++;
//        }
//        if(count!=0){
//            int tail=len+count*2-1;//记录str字符串尾部的存放位置
//            int space=len-1;//记录空格的位置
//            while (count>0){//全部复制
//                while(str.charAt(space)!=' '){
//                    str.setCharAt(tail--,str.charAt(space--));
//                }
//                //开始替换空格
//                str.replace(tail-2,tail,"%20");
//                tail--;
//                count--;
//            }
//        }
//        return str.toString();
//    }
}
