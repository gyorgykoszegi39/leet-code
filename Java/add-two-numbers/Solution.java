class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        ListNode result = new ListNode(sum % 10);
        ListNode digit = result;
        sum /= 10;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null) {
            sum = l1.val + l2.val + sum;
            digit.next = new ListNode(sum % 10);
            sum /= 10;
            l1 = l1.next;
            l2 = l2.next;
            digit = digit.next;
        }

        while(l1 != null) {
            sum = l1.val + sum;
            digit.next = new ListNode(sum % 10);
            sum /= 10;
            l1 = l1.next;
            digit = digit.next;
        }

        while(l2 != null) {
            sum = l2.val + sum;
            digit.next = new ListNode(sum % 10);
            sum /= 10;
            l2 = l2.next;
            digit = digit.next;
        }

        if(sum != 0)
            digit.next = new ListNode(1);

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode a = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode b = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode sum = s.addTwoNumbers(a, b);

        while(sum != null) {
            System.out.print(sum.val + " ");
            sum = sum.next;
        }
    }
}
