package nowCoderClass1.section5.insertSurround;

/**
 * Created by Dell on 2017-05-10.
 */
public class Test {
    public static void main(String[] args){
        int[] A={2,3,5,10};
        ListNode head=new InsertValue().insert(A,A,4);
        ListNode current=head;
        while (current!=null){
            System.out.println("    "+current.val);
            current=current.next;
        }
    }
}
