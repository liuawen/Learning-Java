package part5Linked;

/**
 * 检查链表是否为回文
 * Created by Dell on 2017-07-24.
 */
public class Palindrome {
    //使用快慢指针
    public boolean isPalindrome(ListNode pHead) {
        ListNode quick=pHead;
        ListNode slow=pHead;
        while(quick.next!=null&&quick.next.next!=null){
            slow=slow.next;
            quick=quick.next.next;
        }
        ListNode current=slow.next;
        slow.next=null;
        quick=reverse(current);
        slow=pHead;
        while(quick!=null){
            if(quick.val==slow.val){
                quick=quick.next;
                slow=slow.next;
            }else{
                return false;
            }
        }
        return true;
    }
    public ListNode reverse(ListNode kHead){
        ListNode head=null;
        ListNode temp;
        while(kHead!=null){
            temp=kHead.next;
            //将kHead插入head中
            kHead.next=head;
            head=kHead;
            kHead=temp;
        }
        return head;
    }
}
