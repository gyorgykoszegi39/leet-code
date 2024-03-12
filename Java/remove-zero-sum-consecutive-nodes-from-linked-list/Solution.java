import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> removeSequence = new HashMap<>();
        int sum = 0;
        ListNode newHead = new ListNode(sum, head), tmpHead = newHead;
        while(tmpHead != null) {
            sum += tmpHead.val;
            removeSequence.put(sum, tmpHead);
            tmpHead = tmpHead.next;
        }

        sum = 0;
        tmpHead = newHead;
        while(tmpHead != null) {
            sum += tmpHead.val;
            tmpHead.next = removeSequence.get(sum).next;
            tmpHead = tmpHead.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(-3, new ListNode(3, new ListNode(1, null)))));
        head = s.removeZeroSumSublists(head);

        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}