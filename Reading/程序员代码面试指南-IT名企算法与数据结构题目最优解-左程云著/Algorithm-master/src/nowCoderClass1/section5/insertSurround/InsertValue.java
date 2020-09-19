package nowCoderClass1.section5.insertSurround;

/**
 * Created by Dell on 2017-05-09.
 */
public class InsertValue {
    public ListNode insert(int[] A, int[] nxt, int val) {
        ListNode insert=new ListNode(val);
        if(A.length==0){
            insert.next=insert;
            return insert;
        }
        if(A.length==1){
            ListNode node=new ListNode(A[0]);
            insert.next=node;
            node.next=insert;
            if(val<A[0]){
                return insert;
            }else{
                return node;
            }
        }

        /**
         * 要创建这个链表
         * 一般情况，找到插入的位置，然后找到该位置前的节点
         */
        ListNode head=new ListNode(A[0]);
        ListNode current=head;
        ListNode previous=head;//=new ListNode(A[nxt[nxt.length-1]])
        boolean flag=true;
        //生成链表
        int i=1;
        for(;i<A.length;i++){//遍历整个A链表
            current=current.next=new ListNode(A[i]);
        }
        ListNode tail=current;
        current.next=head;
        //插入
        previous=current;
        current=head;
        //一般情况的插入，不考虑头和尾
        for(i=1;i<A.length;i++){
            previous=current;
            current=current.next;
            if(previous.val<val&&val<=current.val){
                //插入,在previous和current之间插入
                previous.next=insert;
                insert.next=current;
                previous=tail;
                break;
            }
        }
        if(i==A.length){//说明insert是最大或最小
            previous=current;//末尾
            current=head;//头
            previous.next=insert;
            insert.next=current;
            if(val<=head.val){//最小
                head=insert;
            }else{//最大
                previous=insert;
            }
        }
        previous.next=null;
        return head;

    }


}
