package company.netEasyCode.p8candyNum;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-07.
 */
public class Main {
    /**
     * 计算糖果
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] arr=new int[4];
        for(int i=0;i<4;i++) {
            arr[i]= in.nextInt();
        }

        System.out.println(count(arr));
    }
    public static String count(int[] arr){
        if(((arr[0]+arr[2])&1)==0){
            arr[0]=(arr[0]+arr[2])/2;
            if(((arr[1]+arr[3])&1)==0){
                arr[1]=(arr[1]+arr[3])/2;
                arr[2]=arr[3]-arr[1];
                if(arr[0]>=0&&arr[1]>=0&&arr[2]>=0)
                    return arr[0]+" "+arr[1]+" "+arr[2];
            }
        }
        return "No";
    }

}
