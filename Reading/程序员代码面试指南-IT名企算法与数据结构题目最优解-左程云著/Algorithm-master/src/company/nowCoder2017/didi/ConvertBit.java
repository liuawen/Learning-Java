package company.nowCoder2017.didi;

import java.util.Scanner;

/**
 * 进制转换
 * Created by Dell on 2017-09-09.
 */
public class ConvertBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int base=sc.nextInt();
        System.out.println(convert(n,base));
    }
    public static String convert(int n,int base){
        String s="",table="0123456789ABCDEF";
        boolean f=false;
        if(n<0){
            n=-n;
            f=true;
        }
        while(n!=0){
            s=table.charAt(n%base)+s;
            n=n/base;
        }
        if(s.length()==0){
            s="0";
        }
        if(f&&!s.equals("0")){
            s="-"+s;
        }
        return s;
    }
}
