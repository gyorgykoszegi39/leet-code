class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head, tmp, prev, tmpNext;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        tmpNext = slow.next;
        slow.next = null;
        slow = tmpNext;
        prev = null;
        while (slow != null) {
            tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }

        tmp = head;    
        while(tmp != null && prev != null){
            tmpNext = tmp.next;                                    
	        tmp.next = prev;
			tmp = prev;
            prev = tmpNext;                        
        }                
    }       

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        s.reorderList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
