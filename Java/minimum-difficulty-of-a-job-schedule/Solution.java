import java.util.Arrays;

public class Solution {

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d)
            return -1;
        
        int[][] dp = new int[d + 1][n + 1];
        for(int i = 0; i <= d; i++)
            for(int j = 0; j <= n; j++)
                dp[i][j] = -1;

        return solve(dp, jobDifficulty, 0, d, n);
    }

    private int solve(int dp[][], int[] jobDifficulty, int i, int d, int n) {
        if(dp[d][i] != -1)
            return dp[d][i];
        
        if(d == 1) {
            dp[d][i] = getMaxValue(jobDifficulty, i, n);
            return dp[d][i];
        }
        
        int result = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int j = i; j <= n - d; j++) {
            max = Math.max(max, jobDifficulty[j]);
            result = Math.min(result, max + solve(dp, jobDifficulty, j + 1, d - 1, n));
        }

        dp[d][i] = result;

        return dp[d][i];
    }

    private int getMaxValue(int[] jobDifficulty, int start, int n) {
        int max = jobDifficulty[start];
        for(int i = start + 1; i < n; i++) {
            max = Math.max(max, jobDifficulty[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minDifficulty(new int[] { 6, 5, 4, 3, 2, 1}, 2));
        System.out.println(s.minDifficulty(new int[] { 9, 9, 9}, 4));
        System.out.println(s.minDifficulty(new int[] { 1, 1, 1}, 3));
    }
}
