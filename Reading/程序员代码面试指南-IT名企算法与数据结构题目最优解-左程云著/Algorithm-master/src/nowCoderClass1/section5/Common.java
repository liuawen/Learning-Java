package nowCoderClass1.section5;

import java.util.ArrayList;
import java.util.List;

/**
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 * {1,2,3,4,5,6,7},{2,4,6,8,10}

 返回：[2.4.6]
 * Created by Dell on 2017-05-10.
 */
public class Common {
    public int[] findCommonParts(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        List<Integer> list=new ArrayList<Integer>();
        while(headA!=null&&headB!=null){
            if(headA.val==headB.val){
                list.add(headA.val);
                headA=headA.next;
                headB=headB.next;
            }else{
                if(headA.val<headB.val){
                    headA=headA.next;
                }else{
                    headB=headB.next;
                }
            }
        }
        int[] res=new int[list.size()];
        int index=0;
        for(int s:list){
            res[index]=s;
            index++;
        }
        return res;
    }
}
