package nowCoderClass1.section4;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。

 给定一个int[] numbers(C++中为vector<int>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * Created by Dell on 2017-05-07.
 */
public class TwoStacks {
    //在两个栈的栈顶进行交换
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        Stack<Integer> one=new Stack<Integer>();
        Stack<Integer> two=new Stack<Integer>();
        //将数组中所有元素复制入stackone
        for(int i=0;i<numbers.length;i++){
            one.push(numbers[i]);
        }
        //排序
        sort(one,two);
        //将排好序的复制进ArrayList
        ArrayList<Integer> list=new ArrayList<Integer>();
        //栈顶是第一个元素
        for(int i=0;i<numbers.length;i++){
            list.add(one.pop());
        }
        return list;
    }

    private void sort(Stack<Integer> one, Stack<Integer> two) {
        int current;
        while(!one.isEmpty()){//每次进行一个元素的排序
            current=one.pop();
            if(two.isEmpty()){
                two.add(current);
            }else{//将大的往栈底压
                while((!two.isEmpty())&&current>two.peek()){
                    one.add(two.pop());
                }
                //将current压入
                two.push(current);
            }
        }
        //将two中的所有元素倒到one中
        while(!two.isEmpty()){
            one.push(two.pop());
        }
    }
}
