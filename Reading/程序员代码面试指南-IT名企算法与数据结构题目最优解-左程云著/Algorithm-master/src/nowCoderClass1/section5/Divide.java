package nowCoderClass1.section5;

/**
 * Created by Dell on 2017-05-10.
 */
public class Divide {
    public ListNode listDivide(ListNode head, int val) {
        ListNode small=null,big=null,equal=null,current=null;
        ListNode smallTail=null,bigTail=null,equalTail=null;//记录
        while(head!=null){
            current=head;
            head=head.next;
            current.next=null;
            if(current.val<val){
                if(small==null){
                    small=current;
                    smallTail=current;
                }else{
                    smallTail.next=current;
                    smallTail=current;
                }
            }else{
                if(current.val==val){
                    if(equal==null){
                        equal=current;
                        equalTail=current;
                    }else{
                        equalTail.next=current;
                        equalTail=current;
                    }
                }else{
                    if(big==null){
                        big=current;
                        bigTail=current;
                    }else{
                        bigTail.next=current;
                        bigTail=current;
                    }
                }
            }
        }
        //将小链表组合,考虑小链表为空的情况
        head=null;
        ListNode tail=null;
        if(small!=null){
            head=small;
            tail=smallTail;
        }
        if(equal!=null){
            if(head==null)
                head=equal;
            else
                tail.next=equal;
            tail=equalTail;
        }
        if(big!=null){
            if(head==null)
                head=big;
            else
                tail.next=big;
            tail=bigTail;
        }
        return head;
    }
}
