package company.netEasyExam.p2;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x=new int[n];
        int[] y=new int[n];
        for(int i = 0; i < n; i++){
            x[i]= sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            y[i]= sc.nextInt();
        }
        int[] arr=get(x,y);
        for (int i = 0; i < n-1; i ++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr[n-1]);
    }
    public static int[] get(int[] x,int[] y){
        int[] res=new int[x.length];
        //假设是递增的
        int countX=x[0],countY=y[0],curx=0,cury=0;float d;
        for(int i=1;i<x.length;i++){//坐标（i，1）
           countX+=x[i];countY+=y[i];
           d=i+1;
           curx=Math.round(countX/d);
           cury=Math.round(countY/d);
           int resX=0,resY=0;
           for(int j=0;j<=i;j++){
               resX+=Math.abs(x[j]-curx);
               resY+=Math.abs(y[j]-cury);
           }
           res[i]=resX+resY;
        }
        return res;
    }
}