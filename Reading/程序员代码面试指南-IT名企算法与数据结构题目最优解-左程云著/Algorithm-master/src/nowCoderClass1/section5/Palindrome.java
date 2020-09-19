package nowCoderClass1.section5;

/**请编写一个函数，检查链表是否为回文。
 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * Created by Dell on 2017-05-10.
 */
public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        if(pHead==null||pHead.next==null){
            return true;
        }
        boolean result=false;
        //使用快慢指针，当快指针到最后时，将慢指针后面的翻转，从两边头比较，直到在中间相遇
        ListNode quick=pHead,slow=pHead;
        while (quick.next!=null&&quick.next.next!=null){//不越界
            slow=slow.next;
            quick=quick.next.next;
        }
        //将慢指针后面的翻转
        ListNode quickHead=slow.next;
        ListNode previous=slow,current;
        while (quickHead!=null){
            current=quickHead;
            quickHead=quickHead.next;
            current.next=previous;
            previous=current;
        }
        //从两边向中间
        ListNode left=pHead,right=previous;
        do{
            if(left.val!=right.val){
                return false;
            }else{
                left=left.next;
                right=right.next;
            }
        }while (!left.equals(slow));
        //再比一次
        if(left.val==right.val){
            return true;
        }
        return result;
    }
}
