package nowCoderClass1.section4;

import java.util.Arrays;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * Created by Dell on 2017-05-07.
 */
public class Solution {
    int[] stack=new int[100];
    int[] stackMin=new int[100];
    int count=0;
    public void push(int node) {
        if(count==stack.length){
            expandCapacity();
        }
        stack[count]=node;
        //得到栈最小元素的
        if(count==0){
            stackMin[count]=node;
        }else{
            stackMin[count]=stack[count]<stackMin[count-1]?stack[count]:stackMin[count-1];
        }
        count++;
    }
    private void expandCapacity() {
        Arrays.copyOf(stack,stack.length*2);
        Arrays.copyOf(stackMin,stackMin.length*2);
    }

    /**
     * 弹出一个元素
     */
    public void pop() {
        if(count>0){
            count--;
            stack[count]=0;
            stackMin[count]=0;

        }
    }

    public int top() {
        if(count==0)
            return -1;
        return stack[count-1];
    }

    public int min() {
        if(count==0)
            return -1;
        return stackMin[count-1];
    }
}
