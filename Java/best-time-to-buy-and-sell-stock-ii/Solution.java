public class Solution {
    public static int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int profit = 0;
        int n = prices.length;

        int i = 1;
        
        while( i < n) {
            while(i < n && prices[i - 1] > prices[i]) {
                i++;
            }
            
            //if(i == n) return profit;
            
            buy = prices[i - 1];
            
            while(i < n && prices[i - 1] < prices[i]) {
                i++;
            }
            
            
            profit += prices[i - 1] - buy;
            i++;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(Solution.maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
