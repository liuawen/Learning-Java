package codingInterviewGuide.part2Linked;

/**
 * Created by Dell on 2017-08-04.
 */
public class Main {
    public static void main(String[] args) {
        ListNode one=new ListNode(1,new ListNode(5,new ListNode(3,new ListNode(1,new ListNode(3,new ListNode(5,new ListNode(7,new ListNode(9,null))))))));
        ListNode two=new ListNode(5,new ListNode(5,new ListNode(5,new ListNode(5,new ListNode(3,null)))));
        ListNode res=new AddLists().addLists(one,two);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
