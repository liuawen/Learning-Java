package codingInterviewGuide.part1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Dell on 2017-07-16.
 */
public class WindowMax {
    public int[] getWindowMax(int[] arr,int windowSize){
        Deque<Integer> deque=new ArrayDeque<Integer>();
        if(windowSize<2||arr.length<=windowSize){
            return arr;
        }
        int[] maxarr=new int[arr.length-windowSize+1];
        int temp=0;boolean flag=true;
        //没有判断值是否过期
        for(int i=0;i<arr.length;i++){
            flag=true;
            while(flag){
                if(!deque.isEmpty()){
                    temp=deque.peekLast();//temp存放队尾元素
                    if(arr[temp]<arr[i]){
                        temp=deque.pollLast();
                    }else{
                        deque.addLast(i);
                        flag=false;
                    }
                }else{
                    deque.add(i);
                    flag=false;
                }
            }
            temp=i-windowSize+1;//存放最大值的下标
            if(temp>=0){
                while(i-deque.peekFirst()>windowSize-1){
                    deque.pollFirst();
                }
                maxarr[temp]=arr[deque.peekFirst()];
            }
        }
        return maxarr;
    }
}
