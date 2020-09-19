package nowCoderClass1.section4;

import java.util.Stack;

/**
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * Created by Dell on 2017-05-07.
 */
public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        // write code here
        Stack<Integer> stack=new Stack<Integer>();
        //将数组放入栈中
        for(int i=0;i<n;i++){
            stack.push(A[i]);
        }
        System.out.print("逆序前"+stack.peek());
        //将栈逆序
        reverse(stack);
        System.out.print("逆序后"+stack.peek());
        //将栈中的数放入数组，返回
        for(int i=n-1;i>=0;i--){
            A[i]=stack.pop();
        }
        return A;


    }


    /**
     * 使用get方法每次获取最下面的元素，然后将栈里的元素逆序
     */
        private void reverse(Stack<Integer> stack) {
            int result=get(stack);
            if(stack.isEmpty())
                stack.push(result);
            else{
                reverse(stack);
                stack.push(result);
            }
        }
    /**
     * 将栈反转,使用下列的办法无法将栈反转,只是按原来的顺序压入栈
     */
//    private void reverse(Stack<Integer> stack){
//        int result=(Integer)stack.pop();
//        if(stack.isEmpty()){
//            stack.push(result);
//        }else{
//            reverse(stack);
//            stack.push(result);
//        }
//    }


    /**
     * get()方法，使用递归将栈底元素拿出，将其他元素依次压入栈中
     */
    private int get(Stack stack){
        int result=(Integer)stack.pop();//弹出的是当前的栈顶
        if(stack.isEmpty()){//到了最底层，返回的就是要
            return result;
        }else{
            int last=get(stack);//一层一层，直到取到栈底，然后将栈底元素一层一层往上传，传的过程中顺便将每一层的元素压栈
            stack.push(result);
            return last;
        }
    }
}
