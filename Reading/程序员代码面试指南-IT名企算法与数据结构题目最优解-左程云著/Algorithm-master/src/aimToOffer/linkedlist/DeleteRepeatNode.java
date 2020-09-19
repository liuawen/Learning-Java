package linkedlist;

/**
 * Created by Dell on 2017-06-21.
 */
public class DeleteRepeatNode {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null||pHead.next==null)
            return pHead;
        ListNode pre=null;
        ListNode cur=pHead;
        ListNode behind=cur.next;
        while (cur!=null){
            while(behind!=null&&cur.val==behind.val){
                behind = behind.next;
            }
            try{
                if(cur.next==behind){
                    //不相等
                    pre=cur;
                    cur=behind;
                    behind=cur.next;
                }else{
                    //相等,删除cur，到behind前
                    if(pre==null){//删除的是头结点
                        pHead=behind;
                    }else{//不是头结点
                        pre.next=behind;
                    }
                    cur=behind;
                    behind=cur.next;
                }
            }catch (NullPointerException e){
                return pHead;
            }
        }
        return pHead;
    }
}
