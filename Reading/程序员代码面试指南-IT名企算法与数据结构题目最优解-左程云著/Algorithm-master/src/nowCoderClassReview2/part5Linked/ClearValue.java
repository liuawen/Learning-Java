package part5Linked;

/**
 * 链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * Created by Dell on 2017-07-24.
 */
public class ClearValue {
    public ListNode clear(ListNode head, int val) {
        ListNode cur=head;
        ListNode pre=null;
        while(cur!=null){
            if(cur.val==val){
                if(pre==null){//删除的是头结点
                    head=head.next;
                }else{
                    pre.next=cur.next;
                }
            }else{//维护pre
                pre=cur;
            }
            cur=cur.next;
        }
        return head;
    }
}
