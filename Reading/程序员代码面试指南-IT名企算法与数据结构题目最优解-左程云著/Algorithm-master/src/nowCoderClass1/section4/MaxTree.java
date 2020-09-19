package nowCoderClass1.section4;

import java.util.Stack;

/**
 * Created by Dell on 2017-05-09.
 */
public class MaxTree {

    public int[] buildMaxTree(int[] A, int n) {
        int[] res=new int[n];//存放结果
        Stack<Integer> stack=new Stack<Integer>();
        //从左边开始遍历，找到比左边大的，如果没有，就是空
        int i=0;
        for(;i<n;i++){
            while ((!stack.isEmpty())&&A[stack.peek()]<A[i]){//栈不空就一直向左，直到找出第一个比他大的
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i]=-1;
            }else{
                res[i]=stack.peek();
            }
            stack.push(i);
        }
        //从右边开始，和左边相比，确定下标
        stack.clear();
        int right,index;
        for(i=n-1;i>=0;i--){
            //考察右边，找出右边最大的
            while((!stack.isEmpty())&&A[i]>A[stack.peek()]){
                stack.pop();
            }
            //比较左边和右边，确定树的下标
            //栈空     结果就是左边的值
            //栈不空    左边无最大，或左边是大的，，，，将栈顶赋给下标
            if(!stack.isEmpty()&&(res[i]==-1||A[stack.peek()]<A[res[i]])){
                res[i]=stack.peek();//右边的是父节点
            }
            stack.push(i);
        }
        return res;
    }
}
