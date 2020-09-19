package linkedlist;

/**
 * Created by Dell on 2017-06-11.
 */
public class CopyLinkedList {
    public RandomListNode Clone(RandomListNode pHead) {
        /**
         * 在原链表的中间新增一个节点，复制复杂链表时就能轻易找到random节点的指向
         *
         */
        if(pHead==null)
            return null;
        RandomListNode current=pHead;
        //复制所有节点
        while (current!=null){
            RandomListNode node=new RandomListNode(current.label);
            node.next=current.next;
            current.next=node;
            current=node.next;
        }
        //复制其Random指针
        current=pHead;
        while (current!=null){
            if(current.random!=null){
                current.next.random=current.random.next;
            }
            current=current.next.next;
        }
        //将两条链分开
        current=pHead;
        RandomListNode head=current.next;
        RandomListNode copyCurrent=null;
        while (current!=null){
            copyCurrent=current.next;
            current.next=copyCurrent.next;
            current=current.next;
            if(copyCurrent.next!=null){
                copyCurrent.next=current.next;
            }
        }
        return head;
    }
}
