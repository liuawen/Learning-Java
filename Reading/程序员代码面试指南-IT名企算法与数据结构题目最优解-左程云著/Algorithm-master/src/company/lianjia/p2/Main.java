package company.lianjia.p2;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-19.
 */
public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            System.out.println(get(n));
        }
    }
    public static int get(int n){
        if(n<=2){
            return 1;
        }
        int pre=1;
        int cur=1;
        int temp;
        for(int count=3;count<=n;count++){
            temp=pre+cur;
            pre=cur;
            cur=temp;
        }
        return cur;
    }
}
