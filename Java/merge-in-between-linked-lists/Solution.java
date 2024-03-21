class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node = list1;
        ListNode result = list1;
        a--;
        while(a > 0) {
            a--;
            b--;
            node = node.next;
        }
        
        ListNode tmpNode = node.next.next;
        node.next = list2;
        while(list2.next != null)
            list2 =list2.next;
        
        b--;
        while(b > 0) {
            b--;   
            tmpNode = tmpNode.next;
        }
        list2.next = tmpNode;
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode replace = new ListNode(12, new ListNode(13, new ListNode(14, null)));

        head = s.mergeInBetween(head, 1, 3, replace);

        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
