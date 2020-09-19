package nowCoderClass1.section5;



/**
 * 实现单链表的翻转
 * Created by Dell on 2017-05-10.
 */
public class TurnOver {
    public ListNode turnOver(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        //从头结点开始翻转，相当于改变指针的指向，然后记录新的头部
        ListNode newHead=null;
        ListNode current=null;
        while(head!=null){
            current=head;//将当前的值保存下来
            //right的头结点
            head=current.next;
            //left的
            if(newHead==null){
                newHead=current;
                current.next=null;
            }else{
                current.next=newHead;
                newHead=current;
            }
        }
        return newHead;
    }
}
