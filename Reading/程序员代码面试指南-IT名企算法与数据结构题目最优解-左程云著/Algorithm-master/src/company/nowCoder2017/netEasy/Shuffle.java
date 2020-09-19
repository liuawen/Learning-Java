package company.nowCoder2017.netEasy;

import java.util.Scanner;

/**
 * Created by Dell on 2017-09-08.
 */
public class Shuffle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group=sc.nextInt();
        while(group-->0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[2 * n];
            int[] f=new int[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                arr[i] = sc.nextInt();
            }
            while(k-->0){
                shuffle(arr,f);
                int[] temp=arr;
                arr=f;
                f=temp;
            }
            for (int i = 0; i < 2 * n-1; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println(arr[2*n-1]);
        }
    }
    //洗牌每次根据f，将打乱结果放入s中
    public static void shuffle(int[] f,int[] s){
        for(int i=0;i<f.length;i++){
            if(i<f.length/2){
                s[i*2]=f[i];
            }else{
                s[2*i-f.length+1]=f[i];
            }
        }
    }
}
