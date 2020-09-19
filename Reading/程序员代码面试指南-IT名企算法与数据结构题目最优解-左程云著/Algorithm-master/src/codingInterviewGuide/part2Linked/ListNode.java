package codingInterviewGuide.part2Linked;

/**
 * Created by Dell on 2017-08-04.
 */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}