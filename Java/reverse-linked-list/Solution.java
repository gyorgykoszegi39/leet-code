class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode tmp;
        ListNode result = null;

        while(head != null) {
            tmp = head.next;
            head.next = result;
            result = head;
            head = tmp;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        head = s.reverseList(head);

        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
