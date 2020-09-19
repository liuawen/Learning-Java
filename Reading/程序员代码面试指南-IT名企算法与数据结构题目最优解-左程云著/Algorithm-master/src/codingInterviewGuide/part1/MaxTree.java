package codingInterviewGuide.part1;

import java.util.Arrays;
import java.util.Stack;

/**
 * 使用给定原则生成树
 * Created by Dell on 2017-07-19.
 */
public class MaxTree {
    public TreeNode getMaxTree(int[] arr){
        //首先利用Stack来寻找左边和右边第一个比其大的数
        //stack添加的过程，遇到小的弹出，如果没有遇到小的则加入，
        int[] left=new int[arr.length];int temp=0;
        for(int i=0;i<arr.length;i++){
            left[i]=-1;
        }
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty()&&arr[stack.peek()]<arr[i]){//找左边第一个比他大的
                stack.pop();
            }
            if(!stack.isEmpty()){
                left[i]=stack.peek();
            }
            stack.push(i);
        }
        Arrays.stream(left).forEach(i->System.out.println(i));
        stack.clear();//清空stack
        for(int i=arr.length-1;i>=0;i--){//找右边第一个比他大的，去掉比他小的
            while (!stack.isEmpty()&&arr[stack.peek()]<arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                temp=stack.peek();
                //综合left和right的信息至left中
                if(left[i]!=-1){
                    left[i]=arr[left[i]]<arr[temp]?left[i]:temp;
                }else{
                    left[i]=temp;
                }
            }
            stack.push(i);
        }
        System.out.println();
        Arrays.stream(left).forEach(i->System.out.println(i));
        //构建MaxTree
        TreeNode[] nodes=new TreeNode[arr.length];
        for(int i=0;i<arr.length;i++){
            nodes[i]=new TreeNode(arr[i]);
        }
        TreeNode root=null,cur=null;
        for(int i=0;i<arr.length;i++){
            if(left[i]==-1){
                root=nodes[i];
            }else{
                cur=nodes[left[i]];
                if(cur.left==null){
                    cur.left=nodes[i];
                }else{
                    cur.right=nodes[i];
                }
            }
        }
        return root;
    }
}
