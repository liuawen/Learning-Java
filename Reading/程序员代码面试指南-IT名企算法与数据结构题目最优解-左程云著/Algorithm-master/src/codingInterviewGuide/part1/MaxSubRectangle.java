package codingInterviewGuide.part1;

import java.util.Arrays;
import java.util.Stack;

/**
 * 最大子矩阵，首先将矩阵按行分割，从上至下依次求出每一列的高度，
 * 再求出每个位置上能够构造出的最大的矩阵的面积
 * Created by Dell on 2017-08-02.
 */
public class MaxSubRectangle {
    public int getMaxArea(int[][] arr,int m, int n){
        int[] height=new int[n];
        int res=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){//按行划分
            for(int j=0;j<n;j++) {//求height数组
                height[j]=arr[i][j]==0?0:height[j]+1;
            }
            System.out.println();
            Arrays.stream(height).forEach(k->System.out.print("   "+k));
            //求出一行的可以构成矩阵中最大的
            res=Math.max(res,getRec(height));
            System.out.println(res);
        }
        return res;
    }

    /**
     * 只要知道该位置下左边比它小的数的位置，右边比它小的数的位置，即可求得面积
     * 当下标为j的元素要弹出时，i-1是其最右，j弹出后的栈顶+1是其最左
     * 弹出时可确定其最大构成的矩形的面积
     * 栈的顺序是从小到大，栈顶是最大
     *  栈的使用规则是遇到大的入栈，小的弹出直至比栈顶大
     * @param height
     * @return
     */
    private int getRec(int[] height) {
        Stack<Integer> stack=new Stack<>();
        int res=Integer.MIN_VALUE;
        int index=0,left=0,area=0,right=0;
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty()&&height[i]<=height[stack.peek()]){
                index=stack.pop();//弹出时计算该位置可能达到的面积值
                left=stack.isEmpty()?-1:(stack.peek());
                left++;right=i-1;
                area=(right-left+1)*height[index];//注意右是i-1
                res=Math.max(res,area);
            }
            //此时栈中保存的是比i位置小的,或为空
            stack.push(i);
        }
        //如果栈中还有元素，计算其面积
        while(!stack.isEmpty()){
            index=stack.pop();//弹出时计算该位置可能达到的面积值
            left=stack.isEmpty()?-1:(stack.peek());
            left++;right=height.length-1;
            area=(right-left+1)*height[index];//注意右是i-1
            res=Math.max(res,area);
        }
        return res;
    }


}
