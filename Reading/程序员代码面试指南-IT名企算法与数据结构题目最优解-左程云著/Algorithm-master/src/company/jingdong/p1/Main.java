package company.jingdong.p1;

/**
 * Created by Dell on 2017-09-08.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //注意while处理多个case
        String line=in.nextLine();
        System.out.println(voilence(line));
    }
    //暴力递归求解
    public static int voilence(String str){
        if(str==""||str.length()==0){
            return 1;
        }
        int res=0;
        //去掉第一个左括号
        char[] chars=str.toCharArray();
        if(chars[1]==')'){
            res+=voilence(str.substring(2));
        }else{//选择后面的括号,选哪个括号都是可行的
            for(int i=2;i<chars.length;i++){
                if(chars[i]==')'){
                    StringBuilder sb=new StringBuilder();
                    String s=str.substring(1,i)+str.substring(i+1);
                    res+=voilence(s);
                }
            }
        }
        return res;
    }
}
