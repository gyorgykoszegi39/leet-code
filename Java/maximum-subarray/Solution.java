public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = Integer.MIN_VALUE;
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            maxSum = Math.max(dp[i], maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
