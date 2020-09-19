package stack;

import java.util.Stack;

/**
 * Created by Dell on 2017-06-09.
 */
public class PushOrder {
    /**
     * pushA是入栈序列，popA是出栈序列
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack stack=new Stack();
        int len=pushA.length;
        int countPush=0;
        int countPop=0;
        stack.add(pushA[countPush++]);
        while(countPop<len){
            if(popA[countPop]!=(Integer)stack.peek()){
                if(countPush<len){
                    stack.add(pushA[countPush++]);
                }else {
                    return false;
                }
            }else{
                stack.pop();
                countPop++;
            }
        }
        return true;
    }
}
