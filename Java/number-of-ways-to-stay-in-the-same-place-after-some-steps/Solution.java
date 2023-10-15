public class Solution {
    
    final static long mod = 1_000_000_007;

    public int numWays(int steps, int arrLen) {
        if(arrLen == 1)
            return 1;
            
        arrLen = Math.min(steps / 2 + 1, arrLen);
        long[] dp = new long[arrLen + 1];
        long[] helper = new long[arrLen + 1];
        int maxPos;
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= steps; i++) {
            maxPos = Math.min(arrLen - 1, i);
            helper[0] = (dp[0] + dp[1]) % mod;
            for(int j = 1; j < maxPos; j++) {
                helper[j] = (dp[j - 1] + dp[j] + dp[j + 1]) % mod;
            }
            helper[maxPos] = (dp[maxPos - 1] + dp[maxPos]) % mod;
            long[] tmp = dp;
            dp = helper;
            helper = tmp;
        }
        return (int) dp[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numWays(3, 2));
        System.out.println(s.numWays(2, 4));
        System.out.println(s.numWays(4, 2));
        System.out.println(s.numWays(4, 3));

    }
}
