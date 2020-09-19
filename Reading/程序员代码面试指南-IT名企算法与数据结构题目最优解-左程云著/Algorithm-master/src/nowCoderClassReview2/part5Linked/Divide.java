package part5Linked;

/**
 * Created by Dell on 2017-07-24.
 */
public class Divide {

    public ListNode listDivide(ListNode head, int val) {
        ListNode smallhead=null;
        ListNode smalltail=null;
        ListNode bighead=null;
        ListNode bigtail=null;
        ListNode current=head;
        while (current!=null){
            if(current.val<=val){
                if(smalltail==null){
                    smallhead=current;
                    smalltail=current;
                }else{
                    smalltail.next=current;
                    smalltail=smalltail.next;
                }
                current=current.next;
                smalltail.next=null;
            }else{
                if(bigtail==null){
                    bighead=current;
                    bigtail=current;
                }else{
                    bigtail.next=current;
                    bigtail=bigtail.next;
                }
                current=current.next;
                bigtail.next=null;
            }
        }
        //将两个链表拼起来
        if(smalltail!=null){
            smalltail.next=bighead;
            return smallhead;
        }else{
             return bighead;
        }
    }
}
