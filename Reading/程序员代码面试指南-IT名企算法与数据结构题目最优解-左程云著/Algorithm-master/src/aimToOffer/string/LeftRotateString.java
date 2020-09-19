package string;

/**
 * Created by Dell on 2017-06-13.
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(str.length()<n){
            return "";
        }
        if(n==0){
            return str;
        }
        char[] chars=str.toCharArray();
        rotate(chars,0,chars.length-1);
        rotate(chars,0,chars.length-n-1);
        rotate(chars,chars.length-n,chars.length-1);
        return String.valueOf(chars);
    }
    public void rotate(char[] chars,int begin,int end){
        char temp=' ';
        while(begin<end){
            temp=chars[begin];
            chars[begin++]=chars[end];
            chars[end--]=temp;
        }
    }
}
