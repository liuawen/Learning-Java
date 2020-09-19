package company.ali.examDemo.p1;

import java.util.*;
public class Main {
/** 请完成下面这个函数，实现题目要求的功能 **/
/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int pick(int[] peaches) {
        int[] dp=new int[peaches.length];
        dp[0]=1;int max=0;
        for(int i=1;i<peaches.length;i++){
            for(int j=0;j<i;j++){
                if(peaches[j]<peaches[i]){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+1;
            max=0;
        }
        for(int i=0;i<peaches.length;i++){
            max=max=Math.max(max,dp[i]);
        }
        return max;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int trees = Integer.parseInt(in.nextLine().trim());
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(pick(peaches));
    }
}