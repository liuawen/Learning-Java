package company.netEasyCode.p7apple;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-07.
 */
public class Main {
    /**
     * 买苹果
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(buy(N));
    }
    public static int buy(int N){
        int bag=N/8;
        int over=N%8;
        while(over%6!=0&&bag>0){//一直到可以买完整的6个
            bag--;
            over+=8;
        }
        //可能是bag8==0了
        if(over%6==0){
            return bag+(over/6);
        }
        return -1;
    }

}
