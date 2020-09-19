package company.huawei.p3radixTranfer;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-08.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNextLine()){
            String str=in.nextLine().substring(2);
            int a=Integer.parseInt(str,16);
            String b=Integer.toString(a,10);
            System.out.println(b);
        }
    }

}
