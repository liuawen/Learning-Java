package nowCoderClass1.section5;


/**
 * Created by Dell on 2017-05-10.
 */
public class Test {
    public static void main(String[] args){
        //TurnOver
        ListNode head=new ListNode(3);
        ListNode a=new ListNode(15);
        ListNode b=new ListNode(78);
        ListNode c=new ListNode(35);
        ListNode d=new ListNode(89);
        ListNode e=new ListNode(53);
        ListNode f=new ListNode(62);
        ListNode g=new ListNode(37);
//        ListNode h=new ListNode(78);
        head.next=a;
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;

        ListNode h=b;//测试下改变h改变的是整个链表，使用之后此链表不复存在
        h.next=null;
//        g.next=h;
//        head=new KInverse().inverse(head,3);
//        head=new Divide().listDivide(head,35);
//        head=new TurnOver().turnOver(head);

        while (head!=null){
           System.out.println("    "+head.val);
            head=head.next;
        }








//        int[] A={2,3,5,10};
//        five.insertSurround.ListNode head=new InsertValue().insert(A,A,4);
//        ListNode current=head;
//        while (current!=null){
//            System.out.println("    "+current.val);
//            current=current.next;
//        }
    }
}
