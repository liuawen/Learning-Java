package nowCoderClass1.section5;



/**
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 * Created by Dell on 2017-05-10.
 */
public class KInverse {
    /**
     * 设计一个小链表，设计一个逆序的方法，并设计一个计数的，设计长链表的头和尾，
     * 异常，为空，为1
     * @param head
     * @param k
     * @return
     */
    public ListNode inverse(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        //存放要返回的最新的头部和最新的尾部
        ListNode newHead=null;
        ListNode newTail=null;
        //存放准备进行逆序的元素
        ListNode kHead=null;
        ListNode kTail=null;
        //存放逆序之后的
        ListNode turnHead=null;
        ListNode turnTail=null;
        ListNode turnCurrent=null;
        ListNode current=null;

        int kCount=0;//对准备进行逆序的元素的个数进行判断


        while(head!=null){
            current=head;
            head=head.next;
            if(kCount==k){
                //对k个元素进行逆序
                while(kHead!=null){
                    turnCurrent=kHead;
                    kHead=kHead.next;
                    if(turnHead==null){//相当于在头部插入节点
                        turnHead=turnCurrent;
                        turnCurrent.next=null;
                        turnTail=turnCurrent;
                    }else{
                        turnCurrent.next=turnHead;
                        turnHead=turnCurrent;
                    }
                }
                //添加到new中，
                if(newHead==null){
                    newHead=turnHead;
                    newTail=turnTail;
                }else{
                    newTail.next=turnHead;
                    newTail=turnTail;
                }
                //置空，置0
                kCount=0;turnHead=null;turnTail=null;
            }
            //将元素存放至待调整的节点中
            current.next=null;
            if(kCount==0){
                kHead=current;
                kTail=current;
                kCount++;
            }else{
                kTail.next=current;
                kTail=current;
                kCount++;
            }
        }
        //判断尾部有无剩余，有则添加到尾部
        //判断尾部有无剩余，有则添加到尾部
        if(kCount==k){
            //对k个元素进行逆序
            while(kHead!=null){
                turnCurrent=kHead;
                kHead=kHead.next;
                if(turnHead==null){//相当于在头部插入节点
                    turnHead=turnCurrent;
                    turnCurrent.next=null;
                    turnTail=turnCurrent;
                }else{
                    turnCurrent.next=turnHead;
                    turnHead=turnCurrent;
                }
            }
            //添加到new中，
            if(newHead==null){
                newHead=turnHead;
                newTail=turnTail;
            }else{
                newTail.next=turnHead;
                newTail=turnTail;
            }
            //置空，置0
            kCount=0;turnHead=null;turnTail=null;

        }else{
                if(newHead==null){
                    newHead=kHead;
                }else{
                    newTail.next=kHead;
                }
        }
        return newHead;
    }
}
