package company.nowcoder2016;

import java.util.Scanner;

/**
 * Created by Dell on 2017-09-11.
 */
public class NumericKeypad {
    void locate(int digit,int x,int y){

    }
    /*
            0   1   2
        0   1   2   3
        1   4   5   6
        2   7   8   9
        3       10
     */
    static boolean reach(int x,int y){
        int x0,y0,x1,y1;
        int digit0=x-'0'!=0?x-'0'-1:10;
        x0=digit0/3;//取得行
        y0=digit0%3;//取得列
        int digit1=y-'0'!=0?y-'0'-1:10;
        x1=digit1/3;
        y1=digit1%3;
        return x0<=x1&&y0<=y1;//如果x的行和列都小于y，可行，返回true
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.valueOf(sc.nextLine());
        char[] str=null;
        for(int z=0;z<n;z++){
            str=sc.nextLine().toCharArray();
            for(int i=0;i<str.length-1;i++){//个位不用参与循环
                while (!reach(str[i],str[i+1])){//不能得到该数字
                    if(--str[i+1]<'0'){//不明白这里
                        str[i--]--;
                    }
                    for(int j=i+2;j<str.length;j++)//如果i没有减，
                        str[j]='9';

                }
            }
            for(char t:str){
                System.out.print(t);
            }
            System.out.println();
        }
    }


}
