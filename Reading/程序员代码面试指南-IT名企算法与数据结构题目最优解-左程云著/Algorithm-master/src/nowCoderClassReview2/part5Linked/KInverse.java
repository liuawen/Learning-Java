package part5Linked;

/**
 * Created by Dell on 2017-07-24.
 */
public class KInverse {
    /**
     * 每K个逆序，不足K个，不逆序
     */
    public ListNode inverse(ListNode head, int k) {
        if(k<2)
            return head;
        int count=0;//负责计数
        ListNode resHead=null;
        ListNode resTail=null;
        ListNode kHead=null;
        ListNode kTail=null;
        ListNode temp=null;
        while(head!=null){
            if(count==0){//设置KHead
                kHead=head;
            }
            if(++count==k){
                kTail=head;
                head=head.next;
                kTail.next=null;//切断kTail和head的联系
                //调用反转的方法//链接到res中
                temp=reverse(kHead);
                if(resHead==null){
                    resHead=temp;
                }else {
                    resTail.next = temp;
                }
                //更新resTail
                while(temp.next!=null){
                    temp=temp.next;
                }
                resTail=temp;
                //初始化count，K
                count=0;
            }else{
                head=head.next;
            }
        }
        //检查是否还有不足K个的，链接到res中
        if(count!=0){
            if(resHead!=null){
                resTail.next=kHead;
            }else{
                resHead=kHead;
            }
        }
        return resHead;
    }

    /**
     * 翻转K个链表,使用头插法，每次从链表中取下一个，插入到head的头部即可
     * @param kHead
     */
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
