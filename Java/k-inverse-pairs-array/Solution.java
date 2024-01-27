
public class Solution {
    final static int mod = 1_000_000_007;

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        for(int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
                if(j >= i)
                    dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + mod) % mod;
            }

        return dp[n][k];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.kInversePairs(3, 0));
        System.out.println(s.kInversePairs(3, 1));
        System.out.println(s.kInversePairs(10, 11));
    }
}
