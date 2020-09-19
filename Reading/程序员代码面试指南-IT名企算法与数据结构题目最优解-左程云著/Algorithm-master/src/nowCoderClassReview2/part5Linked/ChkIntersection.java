package part5Linked;

/**
 * Created by Dell on 2017-07-24.
 */
public class ChkIntersection {
    /**
     * 两个链表判是否相交，有环和无环
     * @param head1
     * @param head2
     * @param adjust0
     * @param adjust1
     * @return
     */
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        ListNode circle1=haveCircle(head1);
        ListNode circle2=haveCircle(head2);
        if(circle1==null&&circle2==null){
            //均为无环链表,判断最后一个节点是否相同即可
            while(head1.next!=null){
                head1=head1.next;
            }
            while(head2.next!=null){
                head2=head2.next;
            }
            return head1==head2;
        }else if(circle1!=null&&circle2!=null){
            //均为有环链表,判断入环结点是否相同
            if(circle1==circle2)
                return true;
            //固定一个环，另一个走一圈，看是否能碰到
            ListNode p=circle1.next;
            while(p!=circle1){
                if(p==circle2)
                    return true;
                p=p.next;
            }
            return false;
        }
        return false;//一个有环一个无环，不可能相交

    }
    //快慢指针,判是否有环
    public ListNode haveCircle(ListNode head){
        ListNode slow=head,quick=head;
        while(quick.next!=null&&quick.next.next!=null){
            slow=slow.next;
            quick=quick.next.next;
            if(slow==quick){
                //有环，求入环结点
                quick=head;
                while(quick!=slow){
                    slow=slow.next;
                    quick=quick.next;
                }
                return quick;
            }
        }
        return null;
    }
}
