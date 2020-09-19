package linkedlist;

public class Main {

    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(1);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(3);
        ListNode e=new ListNode(6);
        ListNode f=new ListNode(6);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        ListNode res=new DeleteRepeatNode().deleteDuplication(a);
        while(res!=null) {
            System.out.println(res.val);
            res=res.next;
        }
//        RandomListNode a=new RandomListNode(1);
//        RandomListNode b=new RandomListNode(2);
//        RandomListNode c=new RandomListNode(3);
//        RandomListNode d=new RandomListNode(4);
//        a.next=b;
//        b.next=c;
//        c.next=d;
//        b.random=a;
//        c.random=d;
//        new CopyLinkedList().Clone(a);
//        System.out.println("Hello World!");
    }
}
