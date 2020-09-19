package company.nowCoder2017.netEasy;

import java.util.Scanner;

/**
 * Created by Dell on 2017-09-07.
 */
public class TwoOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr=new String[n];
        for(int i = 0; i < n; i++){
            arr[i]= sc.nextLine();
        }
        boolean dict=true;
        for(int i = 1; i < n; i++){
            if(!isDict(arr[i-1],arr[i])){
                dict=false;
                break;
            }
        }
        boolean len=true;
        for(int i = 1; i < n; i++){
            if(arr[i-1].length()>arr[i].length()){
                len=false;break;
            }
        }
        if(dict&&len){
            System.out.println("both");
        }else if(dict==false&&len){
            System.out.println("lengths");
        }else if(len==false&&dict){
            System.out.println("lexicographically");
        }else{
            System.out.println("none");
        }
    }
    public static boolean isDict(String a,String b){
        int i=0;
        for(i=0;i<Math.min(a.length(),b.length());i++){
            if(a.charAt(i)<b.charAt(i)){
                return true;
            }else if(a.charAt(i)>b.charAt(i)){
                return false;
            }
        }
        if(i==a.length()){
            return true;
        }
        return false;
    }
}
