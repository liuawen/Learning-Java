package company.didi.p3;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-26.
 */
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(find(n));
    }
    public static int find(int n){
        int[] ugly=new int[n];
        ugly[0]=1;
        int index2=0;
        int index3=0;
        int index5=0;
        int index=1;
        while(index<n){
            int val=Math.min(ugly[index2]*2,Math.min(ugly[index3]*3,ugly[index5]*5));
            if(val==ugly[index2]*2){
                ++index2;
            }
            if(val==ugly[index3]*3){
                ++index3;
            }
            if(val==ugly[index5]*5){
                ++index5;
            }
            ugly[index++]=val;
        }
        return ugly[n-1];
    }
}
