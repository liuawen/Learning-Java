package nowCoderClass1.section5;

/**
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。
 * 如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 * Created by Dell on 2017-05-11.
 */
public class ChkLoop {
    /**
     * 判断是否有环，使用快慢指针。问题转变为快慢指针在环内相距m/k,m为不是环的长度，k为环的长度，成为追击问题
     * 相遇之后，将快指针指向头部，以速度为1，继续遍历，下次相遇的位置就是环的入口
     * @param head
     * @param adjust
     * @return
     */
    public int chkLoop(ListNode head, int adjust) {
        // write code here
        if(head==null){
            return -1;
        }
        ListNode quick=head;
        ListNode slow=head;
        ListNode current=head;
        while(current.next!=null&&current.next.next!=null){
            quick=quick.next.next;
            slow=slow.next;
            if(quick==slow){//相遇
                quick=head;
                while (quick!=slow){
                    quick=quick.next;
                    slow=slow.next;
                }
                return slow.val;
            }
            current=quick;
        }
        return -1;
    }
}
