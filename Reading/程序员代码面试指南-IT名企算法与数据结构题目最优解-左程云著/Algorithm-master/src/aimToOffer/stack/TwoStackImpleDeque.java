package stack;

import java.util.Stack;

/**
 * Created by Dell on 2017-06-08.
 */
public class TwoStackImpleDeque {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            //将stack1的元素全部倒出
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
