package nowCoderClass1.section5.randomListNode;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 * Created by Dell on 2017-05-10.
 */
public class Solution {
    /**
     * 将链表的每一个节点复制一份存在当前节点和复杂链表的中间
     * 遍历复杂链表，复制，利用复杂链表指向的节点的右边就是要找的节点
     * 将两个链表拆分开
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
       //复制每个节点在当前节点的右侧
        RandomListNode current=pHead;
        while(current!=null){
            RandomListNode copy=new RandomListNode(current.label);
            copy.next=current.next;
            current.next=copy;
            current=copy.next;
        }
        //遍历整个链表，复制其Random指针
        current=pHead;
        while(current!=null){
            current.next.random=current.random;
            current=current.next.next;
        }
        //将两个链表分开
        current=pHead;
        RandomListNode result=null;
        RandomListNode resultCurrent=null;
        while (current!=null){
            if(result==null){
                result=current.next;
                resultCurrent=result;
            }else{
                resultCurrent.next=current.next;
                resultCurrent=resultCurrent.next;
            }
            current.next=resultCurrent.next;
            current=current.next;
        }
        return result;
    }
}
