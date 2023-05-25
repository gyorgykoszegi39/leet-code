public class Solution {
    public static int maxProfit(int[] prices) {
        int i;
        if (prices.length < 2) {
            return 0;
        }
        
        int maxProfit = 0;
        int bestPrice = prices[0];
        for(i = 1; i < prices.length; i++) {
            if(bestPrice > prices[i]) {
                bestPrice = prices[i];
            } else {
                if(prices[i] - bestPrice > maxProfit) {
                    maxProfit = prices[i] - bestPrice;
                }
            }
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(Solution.maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
