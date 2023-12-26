public class Solution {
    final static int mod = 1_000_000_007;
    private int[][] dp;

    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];
        return solve(n, k, target);
    }

    public int solve(int n, int k, int target) {
        if(n == 0 && target == 0) {
            return 1;
        } 
        if((target < n || n * k < target))
            return 0;
  
        if(dp[n][target] != 0)
            return dp[n][target];

        int count = 0;
        for(int i = 1; i <= k && target >= i; i++) {
            count = (count + solve(n - 1, k, target - i) % mod) % mod;
        }

        dp[n][target] = count;

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numRollsToTarget(1, 6, 3));
        System.out.println(s.numRollsToTarget(2, 6, 7));
        System.out.println(s.numRollsToTarget(3, 6, 7));
        System.out.println(s.numRollsToTarget(4, 6, 7));
        System.out.println(s.numRollsToTarget(30, 30, 500));
    }
}
