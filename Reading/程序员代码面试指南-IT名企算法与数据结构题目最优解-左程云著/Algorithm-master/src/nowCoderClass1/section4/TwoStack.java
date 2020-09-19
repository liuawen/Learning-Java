package nowCoderClass1.section4;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 * Created by Dell on 2017-05-07.
 */
public class TwoStack {
    //给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
    public int[] twoStack(int[] ope, int n) {
        // 队列是先进先出，栈是先进后出，那第二个栈的作用就是取出栈顶，只需要将数据倒一遍即可
        Stack<Integer> one=new Stack<Integer>();
        Stack<Integer> two=new Stack<Integer>();
        ArrayList list=new ArrayList();
        for(int i=0;i<n;i++){
            if(ope[i]==0){
                if(two.isEmpty()){
                    //将数据全部倒入栈2，注意有数据不能倒，要倒就全部倒完
                    while(!one.isEmpty()){
                        two.add(one.pop());
                    }
                }
                //出栈
                list.add(two.pop());
            }else{
                one.push(ope[i]);
            }
        }
        int[] res=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=(Integer) list.get(i);
        }
        return res;
    }
}
