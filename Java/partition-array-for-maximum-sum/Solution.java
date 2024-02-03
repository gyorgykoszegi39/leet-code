
public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length, sum, max;
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            max = 0;
            sum = 0;
            for(int j = 1; j <= k && i - j >= 0; j++) {
                max = Math.max(max, arr[i - j]);
                sum = Math.max(max * j + dp[i - j], sum);
            }
            dp[i] = sum;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxSumAfterPartitioning(new int[] {1, 15, 7, 9, 2, 5, 10}, 3));
        System.out.println(s.maxSumAfterPartitioning(new int[] {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
        System.out.println(s.maxSumAfterPartitioning(new int[] {1}, 1));

    }
}
