package nowCoderClass1.section5;

/**
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * Created by Dell on 2017-05-10.
 */
public class ClearValue {
    public ListNode clear(ListNode head, int val) {
        //特殊处理头结点的删除
        if(head==null){
            return head;
        }
        if(head.next==null){
            if(head.val==val){
                return null;
            }
            return head;
        }

        ListNode current=head;
        //将头部等于val的删除
        while (current.val==val){
            head=current.next;
            current=head;
        }
        ListNode previous=head;
        current=head.next;
        while(current!=null){
            if(current.val==val){
                //删除
                previous.next=current.next;
                current=previous.next;

            }else{
                previous=current;
                current=current.next;
            }

        }
        return head;
    }
}
