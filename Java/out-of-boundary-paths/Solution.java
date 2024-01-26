public class Solution {
    final static long mod = 1_000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long dp[][][] = new long[m + 1][n + 1][maxMove + 1];

        for(int i = 0; i <= m; i++)
            for(int j = 0; j <= n; j++)
                for(int k = 0; k <= maxMove; k++)
                    dp[i][j][k] = -1;

        return (int) (countPahts(dp, m, n, maxMove, startRow, startColumn) % 1_000_000_007);
    }

    public long countPahts(long dp[][][], int m, int n, int maxMove, int i, int j) {
        if(maxMove < 0)
            return 0;

        if(i < 0 || i == m || j < 0 || j == n)
            return 1;

        if(dp[i][j][maxMove] != -1)
            return dp[i][j][maxMove];
        
        return dp[i][j][maxMove] = (countPahts(dp, m, n, maxMove - 1, i - 1, j)
            + countPahts(dp, m, n, maxMove - 1, i + 1, j)
            + countPahts(dp, m, n, maxMove - 1, i, j - 1)
            + countPahts(dp, m, n, maxMove - 1, i, j + 1)) % mod;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findPaths(2, 2, 2, 0, 0));
        System.out.println(s.findPaths(1, 3, 3, 0, 1));
    }
}
