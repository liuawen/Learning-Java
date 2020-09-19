package company.nowCoder2017.netEasy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Dell on 2017-09-07.
 */
public class RecoverArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            arr[i]= sc.nextInt();
            if(arr[i]!=0){
                set.add(arr[i]);
            }
        }
        int[] res=new int[1];
        recover(arr,k,set,0,res,new Stack<Integer>(),0);
        System.out.println(res[0]);
    }
    public static void recover(int[] arr, int k, HashSet<Integer> set, int pos, int[] res, Stack<Integer> stack, int curK){
        if(pos==arr.length){
            if(curK==k) {res[0]++;}
            return;
        }
        //枚举该位置，前提是该位置为0
        if(arr[pos]==0) {
            for (int i = 1; i <= arr.length; i++) {
                if (!set.contains(i)) {
                    int index=insertAndReturnPos(i, stack);//index就是i插入的位置
                    set.add(i);
                    recover(arr,k,set,pos+1,res,stack,curK+index);
                    set.remove(i);
                    stack.remove(index);//根据下标删除
                }
            }
        }else {//已经包含的时候也要计算curK
            int index=insertAndReturnPos(arr[pos], stack);
            recover(arr,k,set,pos+1,res,stack,curK+index);
            stack.remove(index);
        }
    }
    //维护一个单调栈,从小到大
    public static int insertAndReturnPos(int value,Stack<Integer> stack){
        if(!stack.isEmpty()&&value<stack.peek()){
            int v=stack.pop();
            int index=insertAndReturnPos(value,stack);
            stack.add(v);
            return index;
        }else{
            stack.add(value);
            return stack.size()-1;//最后返回
        }
    }

}
