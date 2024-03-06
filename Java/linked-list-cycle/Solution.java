class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        //Floyed's Cycle
        ListNode fast = head.next, slow = head;

        while(fast != null && fast.next != null) {
            if(fast == slow)
                return true;

            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode loop = new ListNode(2, new ListNode(0, new ListNode(-4)));
        ListNode node = new ListNode(3, loop);
        loop.next.next.next = loop;

        System.out.println(s.hasCycle(node));

    }
}
