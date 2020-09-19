package nowCoderClass1.section5.randomListNode;

/**
 * Created by Dell on 2017-05-10.
 */
public class Test {
    public static void main(String[] args){
        RandomListNode pHead=new RandomListNode(1);
        RandomListNode two=new RandomListNode(2);
        RandomListNode three=new RandomListNode(3);
        pHead.next=two;
        two.next=three;
        pHead.random=three;
        two.random=pHead;
        three.random=two;
        RandomListNode head=new Solution().Clone(pHead);
        while(head!=null){
            System.out.println(head+"            "+head.label+"     "+head.next+"     "+head.random);
            head=head.next;
        }
    }
}
