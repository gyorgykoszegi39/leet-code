class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    
    public ListNode doubleIt(ListNode head) {
        ListNode result = head, prev = null;
        int prod;
        while(head != null) {
            prod = 2 * head.val;
            if(prod > 9) {
                if(prev == null)
                    result = new ListNode(1, result);
                else
                    prev.val++;
                
            }

            head.val = prod % 10;
            prev = head;
            head = head.next;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode listNode = new ListNode(9, new ListNode(9, new ListNode(9)));

        listNode = s.doubleIt(listNode);
        
        while(listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
