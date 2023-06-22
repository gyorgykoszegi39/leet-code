
public class Solution {

    public int maxProfit(int[] prices, int fee) {
        int buy, sell, last_buy;

        buy = Integer.MIN_VALUE;
        sell = 0;
        if (prices.length < 2)
            return 0;
        buy = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            last_buy = buy;
            buy = Math.max(buy, sell - prices[i] - fee);
            sell = Math.max(sell, last_buy + prices[i]);
        }

        return sell;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[] { 1,3,2,8,4,9 }, 2));
    }
}
