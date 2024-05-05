class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode deletedNode = new ListNode(4, new ListNode(3));
        ListNode listNode = new ListNode(2, deletedNode);

        s.deleteNode(deletedNode);
        
        while(listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
