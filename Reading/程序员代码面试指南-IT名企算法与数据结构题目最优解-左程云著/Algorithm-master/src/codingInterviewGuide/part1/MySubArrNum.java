package codingInterviewGuide.part1;

import java.util.LinkedList;

/**
 * Created by Dell on 2017-08-03.
 */
public class MySubArrNum {
    public static int getArrNum(int[] arr, int num) {
        LinkedList<Integer> qmax=new LinkedList<>();
        LinkedList<Integer> qmin=new LinkedList<>();
        int res=0;
        int i=0,j=0;
        while (i<arr.length){
            while (j<arr.length){
                while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[j]){
                    qmax.pollLast();
                }
                while (!qmin.isEmpty()&&arr[qmin.peekLast()]>=arr[j]){
                    qmin.pollLast();
                }
                qmax.addLast(j);
                qmin.addLast(j);
                if(arr[qmax.peekFirst()]-arr[qmin.peekFirst()]>=num){
                    break;
                }
                j++;
            }
            res+=j-i;
            if(qmax.peekFirst()==i){
                qmax.pollFirst();
            }
            if(qmin.peekFirst()==i){
                qmin.pollFirst();
            }
            i++;
        }
        return res;
    }
}
