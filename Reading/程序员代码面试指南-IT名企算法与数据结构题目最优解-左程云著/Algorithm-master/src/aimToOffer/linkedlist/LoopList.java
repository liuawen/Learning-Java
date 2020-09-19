package linkedlist;

/**
 * Created by Dell on 2017-06-21.
 */
public class LoopList {
    /**
     * 一个链表中包含环，返回入环节点,快慢指针走，相遇后，快指针指向头，两指针一起走，相遇的地方就是入环节点
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null)
            return null;
        ListNode quick=pHead,slow=pHead;
        if(quick.next==null||quick.next.next==null)
            return null;
        do {
            quick=quick.next.next;
            slow=slow.next;
        }while(quick.next!=null&&quick.next.next!=null&&quick!=slow);
        //结束循环有两种情况，quick.next为空，quick==slow
        if(quick==slow){
            quick=pHead;
            while(quick!=slow){
                quick=quick.next;
                slow=slow.next;
            }
            return quick;
        }else{
            return null;
        }
    }
}
