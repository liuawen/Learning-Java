package linkedlist;

/**
 * Created by Dell on 2017-06-09.
 */
public class BackKNode {
    /**
     * 倒数第K个节点，考虑的异常情况有链表长度不足K，k为0，链表为空
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k==0){
            return null;
        }
        //一个指针先走k步
        ListNode pre=head;
        ListNode behind=head;
        int count=k;
        while(count-->0){
            if(pre!=null){
                pre=pre.next;
            }else{
                return null;
            }
        }
        //两个指针一起走
        while(pre!=null){
            pre=pre.next;
            behind=behind.next;
        }
        return behind;
    }
}
