import java.util.Arrays;

public class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 999_000_000);
        dp[0] = 0;

        for(int i = 0; i < n; i++)
            for(int j = n; j > 0; j--)
                dp[j] = Math.min(dp[j], dp[Math.max(j - time[i] - 1, 0)] + cost[i]);

        return dp[n];
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.paintWalls(new int[]{1, 2, 3, 2}, new int[] {1, 2, 3, 2}));
    }
}
