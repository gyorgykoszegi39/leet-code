public class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;

        for(int i = 0; i < k; i++)
            count += Math.min(tickets[i], tickets[k]);
        
        tickets[k]--;
        for(int i = k; i < tickets.length; i++)
            count += Math.min(tickets[i], tickets[k]);
        
        return count + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.timeRequiredToBuy(new int[] {2, 3, 2}, 2));
        System.out.println(s.timeRequiredToBuy(new int[] {5, 1, 1, 1}, 0));
    }
}