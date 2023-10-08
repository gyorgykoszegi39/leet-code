public class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];  
        int product;

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Integer.MIN_VALUE;
                } else {
                    product = nums1[i - 1] * nums2[j - 1];
                    dp[i][j] = Math.max(
                        product + Math.max(dp[i - 1][j - 1], 0),
                        Math.max(dp[i - 1][j], dp[i][j - 1])
                    );
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}));
        System.out.println(s.maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}));
        System.out.println(s.maxDotProduct(new int[]{-1, -1}, new int[]{1, 1}));
    }
}
