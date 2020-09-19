package codingInterviewGuide.part1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Dell on 2017-08-03.
 */
public class SubArrNum {
    public int getArrNum(int[] arr,int num){
        Deque<Integer> qmax=new ArrayDeque<Integer>();
        Deque<Integer> qmin=new ArrayDeque<Integer>();
        int count=0;int min=0,max=0;
        for(int i=0;i<arr.length;i++){
            while(!qmax.isEmpty()&&arr[qmax.peekLast()]<arr[i]){//将qmax队尾比arr[i]小的元素下标弹出
                qmax.pollLast();
            }
            qmax.addLast(i);
            while(!qmin.isEmpty()&&arr[qmin.peekLast()]>arr[i]){//将qmax队尾比arr[i]小的元素下标弹出
                qmin.pollLast();
            }
            qmin.addLast(i);

            min=qmin.peekFirst();
            max=qmax.peekFirst();
            while(arr[max]-arr[min]>=num){
                if(max<min){
                    qmax.pollFirst();
                    max=qmax.peekFirst();
                }else{
                    qmin.pollFirst();
                    min=qmin.peekFirst();
                }
            }
            count+=qmax.size()*qmin.size();
        }
        return count;
    }
}
