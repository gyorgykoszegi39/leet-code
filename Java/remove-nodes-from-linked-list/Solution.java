class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    
    public ListNode removeNodes(ListNode head) {
        ListNode reverseListNode = reverse(head);
        ListNode result = new ListNode(-1), tmpResult = result;
        int prevVal = -1;
        while(reverseListNode != null) {
            if(reverseListNode.val >= tmpResult.val) {
                tmpResult.next = reverseListNode;
                tmpResult = reverseListNode;

            }

            reverseListNode = reverseListNode.next;
        }
        
        tmpResult.next = null;
        return reverse(result.next);
    }

    public ListNode reverse(ListNode head) {

        ListNode prev = null, next, tmp = head;

        while(tmp != null) {
            next = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = next;
        }

        return prev;
    }

    public ListNode removeNodes1(ListNode head) {
        if(head == null)
            return null;

        ListNode tmp = head;
        ListNode hasGreaterValue = removeNodes(tmp.next);

        tmp.next = hasGreaterValue;
        if(hasGreaterValue == null || tmp.val >= hasGreaterValue.val)
            return tmp;
        
        return hasGreaterValue;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode listNode = new ListNode(123, new ListNode(14, new ListNode(15)));

        listNode = s.removeNodes(listNode);
        
        while(listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
