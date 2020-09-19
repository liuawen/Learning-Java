package company.netEasyCode.p5reverseNum;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-07.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

        System.out.println(rev(rev(x)+rev(y)));
    }
    public static int rev(int x){
        char[] c=Integer.toString(x).toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=c.length-1;i>=0;i--){
            sb.append(c[i]);
        }
        return Integer.parseInt(sb.toString());
    }
}
