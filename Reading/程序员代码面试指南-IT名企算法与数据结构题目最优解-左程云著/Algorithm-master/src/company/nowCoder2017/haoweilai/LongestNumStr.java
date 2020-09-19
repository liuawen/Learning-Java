package company.nowCoder2017.haoweilai;

import java.util.Scanner;

/**
 * Created by Dell on 2017-09-09.
 */
public class LongestNumStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        char[] chars=str.toCharArray();
        int count=0;
        String longest="";
        for(int i=0;i<chars.length;i++){
            if(chars[i]<'0'||chars[i]>'9'){
                if(count>longest.length()){
                    longest=str.substring(i-count,i);
                }
                count=0;
            }else{
                count++;
            }
        }
        if(count>longest.length()){
            longest=str.substring(chars.length-count,chars.length);
        }
        System.out.println(longest);
    }
}
