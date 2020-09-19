package part4stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 现有一建树方法，对于数组中的每个元素，其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。若两边都不存在比它大的数，那么它就是树根。
 * 请返回一个数组，其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，若为根则值为-1
 * Created by Dell on 2017-07-24.
 */
public class MaxTree {
    public int[] buildMaxTree(int[] A, int n) {
        int[] res=new int[n];//存的是下标
        Stack<Integer> stack=new Stack<Integer>();//存的是下标
        //从前扫描一遍，找到左边比他大的数
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&A[i]>A[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){//两种情况，stack空（不用处理），栈顶大（更新）
                res[i]=stack.peek();
            }else{
                res[i]=-1;
            }
            stack.add(i);//维护现在的值
        }
        Arrays.stream(res).forEach(s->System.out.println(s));
        //从后扫描一遍，找到右边比他大的数，比较，选出较小的一个
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&A[i]>A[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){//两种情况，stack空（不用处理），栈顶大（更新）
                if(res[i]==-1){
                    res[i]=stack.peek();
                }else{
                    if(A[res[i]]>A[stack.peek()]){
                        res[i]=stack.peek();
                    }
                }
            }
            stack.add(i);//维护现在的值
        }
        return res;
    }
}
