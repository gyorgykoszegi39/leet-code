class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head, removeElement = head;
        int count = 0;
        while(tmp != null) {
            tmp = tmp.next;
            count++;
        }
        
        n = count - n;
        tmp = head;
        if(n == 0) {
            return head.next == null ? null : head.next;
        }
        n--;
        while(n > 0) {
            n--;
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return head;
    }

    public void printListNode(ListNode node) {
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode node = new ListNode(1, null);
        ListNode node1 = new ListNode(1, new ListNode(2, null));
        ListNode node2 = new ListNode(1, new ListNode(2, null));

        System.out.println("node: ");
        node = s.removeNthFromEnd(node, 1);
        s.printListNode(node);
        System.out.println("node1: ");
        node1 = s.removeNthFromEnd(node1, 2);
        s.printListNode(node1);
        System.out.println("node2: ");
        node2 = s.removeNthFromEnd(node2, 1);
        s.printListNode(node2);

    }
}

