package company.nowCoder2017.haoweilai;

import java.util.Scanner;

/**
 * Created by Dell on 2017-09-09.
 */
public class OverHalfNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int[] arr = new int[strs.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        int curNum=Integer.valueOf(strs[0]);
        int count=1;
        for(int i=1;i<arr.length;i++){
            if(count==0){
                curNum=arr[i];//一旦抵消掉，会换成新的数
                count=1;
            }else if(arr[i]==curNum){
                count++;
            }else{
                count--;
            }
        }
        //检查一下是否超过一半，
        System.out.println(curNum);
    }
}
