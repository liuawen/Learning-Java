package part5Linked;

/**
 * Created by Dell on 2017-07-24.
 */
public class InsertValue {
    /**
     * 环形链表插值
     */
    public ListNode insert(int[] A, int[] nxt, int val) {
        //生成链表
        if(A==null||A.length==0){
            return new ListNode(val);
        }
        ListNode head=new ListNode(A[0]);
        ListNode current=head;
        for(int i=1;i<A.length;i++){
            current.next=new ListNode(A[i]);
            current=current.next;
        }
        //插入val
        current=head;
        ListNode pre=null;
        while (current!=null&&val>current.val){//
            pre=current;
            current=pre.next;
        }
        //val<current   pre之后
        // current==null    pre之后
        ListNode insert=new ListNode(val);
        insert.next=current;
        if(pre==null){//插入的是头
            head=insert;
        }else{
            pre.next=insert;
        }
        return head;
    }

}
