package codingInterviewGuide.part2Linked;

/**
 * Created by Dell on 2017-08-04.
 */
public class AddLists {
    public ListNode addLists(ListNode one,ListNode two){
        one=reverse(one);
        two=reverse(two);
        ListNode cur1=one,cur2=two;
        int re=0;//记录两数相加过程中的余数
        ListNode head=null,temp=null;//使用头插法
        while(cur1!=null&&cur2!=null){

            temp=new ListNode((cur1.val+cur2.val+re)%10);
            re=(cur1.val+cur2.val+re)/10;
//            System.out.println("新建节点"+(cur1.val+cur2.val+re)%10);
            temp.next=head;
            head=temp;
            cur1=cur1.next;
            cur2=cur2.next;
        }
        //将不为空的链表的值相加
        cur1=cur1==null?cur2:cur1;
        while(cur1!=null){

            temp=new ListNode((cur1.val+re)%10);
            re=(cur1.val+re)/10;
            temp.next=head;
            head=temp;
            cur1=cur1.next;
        }
        if(re!=0){
            temp=new ListNode(re);
            temp.next=head;
            head=temp;
        }
        one=reverse(one);
        two=reverse(two);
        return head;
    }
    //使用头插法
    public ListNode reverse(ListNode head){
        ListNode newHead=null;
        ListNode cur=null;
        while(head!=null){
            cur=head;
            head=head.next;
            //将head从旧链表删除，并加入新链表
            cur.next=newHead;
            newHead=cur;
        }
        return newHead;
    }
}
