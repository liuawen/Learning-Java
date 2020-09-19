package company.nowCoder2017.didi;

/**
 * Created by Dell on 2017-09-09.
 */
import java.util.Scanner;

public class ContinueSubArraySum{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(" ");

        int sum=Integer.MIN_VALUE;
        int curSum=0;
        int cur=0;
        for(int i=0;i<str.length;i++){
            curSum+=Integer.valueOf(str[i]);
            sum=Math.max(sum,curSum);
            if(curSum<0){
                curSum=0;
            }
        }
        System.out.println(sum);
    }
}