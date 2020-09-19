package linkedlist;

/**
 * Created by Dell on 2017-06-12.
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null)
            return null;
        ListNode current=pHead1;
        int len1=0;
        while(current!=null){
            len1++;
            current=current.next;
        }
        current=pHead2;
        int len2=0;
        while(current!=null){
            len2++;
            current=current.next;
        }
        ListNode before=null;
        ListNode behind=null;
        if(len1>len2){
            before=pHead1;
            behind=pHead2;
        }else{
            before=pHead2;
            behind=pHead1;
        }
        int len=Math.abs(len1-len2);
        while(len>0){
            before=before.next;
            len--;
        }
        while(before!=null){
            if(before.val==behind.val)
                return before;
            else{
                before=before.next;
                behind=behind.next;
            }
        }
        return null;
    }
}
