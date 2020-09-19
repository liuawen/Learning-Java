package linkedlist;

/**
 * Created by Dell on 2017-06-09.
 */
public class ReverseList {
    /**
     * 反转链表，考虑特殊情况，空链表，只有一个节点的链表
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        //思路是从链表的前端开始一个一个脱离，插入新链表的头部，形成新链表
        ListNode newHead=null;
        ListNode current=head;
        ListNode divided=null;
        while(current!=null){
            divided=current;
            current=current.next;
            //将当前节点脱离
            divided.next=newHead;
            newHead=divided;
        }
        return newHead;
    }
}
