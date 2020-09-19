package stack;

import java.util.Arrays;

/**
 * Created by Dell on 2017-06-09.
 */
public class MyStack {
    int[] stack=null;
    int[] minStack=null;
    int capacity=10;
    int count=0;
    public MyStack(){
        stack=new int[capacity];
        minStack=new int[capacity];
    }
    public MyStack(int capacity){
        this.capacity=capacity;
        stack=new int[capacity];
        minStack=new int[capacity];
    }
    public void push(int node) {
        if(count==capacity){
            expandCapacity();
        }
        if(count==0){
            minStack[count]=node;
        }else{
            minStack[count]=minStack[count-1]<node?minStack[count-1]:node;
        }
        stack[count]=node;
        count++;
    }

    private void expandCapacity() {
        stack= Arrays.copyOf(stack,capacity*2);
        minStack=Arrays.copyOf(minStack,capacity*2);
        capacity*=2;
    }

    public void pop() {
        if(count!=0){
            count--;
        }
    }

    public int top() {
        return stack[count-1];
    }

    public int min() {
        return minStack[count-1];
    }
}
