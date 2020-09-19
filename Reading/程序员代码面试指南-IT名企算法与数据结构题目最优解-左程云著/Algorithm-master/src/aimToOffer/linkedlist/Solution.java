package linkedlist;

import java.util.ArrayList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * Created by Dell on 2017-06-07.
 */
public class Solution {
    /**
     * 三种思路，逆转链表，采用栈，递归，此处使用逆转
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(listNode==null)
            return list;
        addToList(listNode,list);
        return list;
    }
    private void addToList(ListNode cur,ArrayList<Integer> list){
        if(cur!=null){
            addToList(cur.next,list);
            list.add(cur.val);
        }
    }


}
