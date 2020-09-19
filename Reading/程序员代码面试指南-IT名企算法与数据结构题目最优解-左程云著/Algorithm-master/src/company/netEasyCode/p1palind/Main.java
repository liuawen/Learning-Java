package company.netEasyCode.p1palind;

import java.util.Scanner;

/**
 * Created by Dell on 2017-08-07.
 */
public class Main {
    /**
     * 回文序列，变换给出的数据，使之变成回文，最少需要的次数
     * @param args
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=in.nextInt();
        }
        System.out.println(transfer(arr));
    }
    public static int transfer(int[] arr){
        int before=0,end=arr.length-1;
        int count=0;
        while(before<end){
            if(arr[before]==arr[end]){
                before++;end--;
            }else if(arr[before]<arr[end]){
                arr[before+1]+=arr[before];
                before++;count++;
            }else{
                arr[end-1]+=arr[end];
                end--;count++;
            }
        }
        return count;
    }

}
