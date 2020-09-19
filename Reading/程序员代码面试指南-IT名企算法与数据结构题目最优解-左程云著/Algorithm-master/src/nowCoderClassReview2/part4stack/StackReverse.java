package part4stack;

import java.util.Stack;

/**
 * Created by Dell on 2017-07-23.
 */
public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<n;i++){
            stack.add(A[i]);
            System.out.print(stack.pop()+"       ");
        }
        System.out.println("ffffffffffffffffffffffffffffffff");
        reverse(stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+"       ");
        }
        return A;
    }
    public void reverse(Stack<Integer> stack){

        if(!stack.isEmpty()){
            Integer bottom=getBottom(stack);
            reverse(stack);
            stack.add(bottom);
        }
    }

    public Integer getBottom(Stack<Integer> stack){
        Integer element=stack.pop();
        if(stack.isEmpty()){
            return element;
        }else{
            Integer res=getBottom(stack);
            stack.add(element);
            return res;
        }
    }


}
