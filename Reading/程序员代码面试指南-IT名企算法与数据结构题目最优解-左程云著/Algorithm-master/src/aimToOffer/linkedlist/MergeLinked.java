package linkedlist;

/**
 * Created by Dell on 2017-06-09.
 */
public class MergeLinked {
    /**
     * 两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        //合成两个链表
        ListNode c1=list1;
        ListNode c2=list2;
        ListNode head=null;
        ListNode ch=null;
        //给head赋值，后面就不用维护head，只需改变c即可
        if(c1.val<=c2.val){
            head=ch=c1;
            c1=c1.next;
        }else{
            head=ch=c2;
            c2=c2.next;
        }
        while(c1!=null&&c2!=null){
            if(c1.val<=c2.val){
                ch.next=c1;
                ch=c1;
                c1=c1.next;
            }else{
                ch.next=c2;
                ch=c2;
                c2=c2.next;
            }
        }
        ch.next=c1==null?c2:c1;
        return head;
    }
}
