class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
  
public class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode node = head;
        while(node.next != null) {
            node = node.next;
            count++;
        }
        int n = count / 2 + count % 2;
        node = head;
        while(n > 0) {
            n--;
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        Solution s = new Solution();
        System.out.println(s.middleNode(node).val);
    }
}
