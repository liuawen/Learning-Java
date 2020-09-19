package codingInterviewGuide.part1;

import java.util.Stack;

/**
 * Created by Dell on 2017-07-15.
 */
public class ReverseStack {
    /*

     */
    public Stack<Integer> reverse(Stack<Integer> stack){
//        getBottom(stack);
        if(stack.size()<2){
            return stack;
        }
        reverseStack(stack);
        return stack;
    }
    private void reverseStack(Stack<Integer> stack){

        if(!stack.isEmpty()){
            Integer element=getBottomAndRemove(stack);
            reverseStack(stack);
            stack.add(element);
        }
    }


    /*
    获取栈底并移除栈底
     */
    private Integer getBottomAndRemove(Stack<Integer> stack) {
        Integer element=stack.pop();
        if(stack.isEmpty()){
            return element;
        }else{
            Integer result=getBottomAndRemove(stack);
            stack.add(element);
            return result;
        }
    }
}
