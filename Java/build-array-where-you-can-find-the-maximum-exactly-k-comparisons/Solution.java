
public class Solution {

    final static int mod = 1_000_000_007;

    public int numOfArrays(int n, int m, int k) {
        Integer[][][] dp = new Integer[n + 1][m + 1][k + 1];
        return countArrays(n, m, k, 0, 0, 0, dp);
    }

    private int countArrays(int n, int m, int k, int i, int max, int cost, Integer[][][] dp) {
        if(i == n) {
            if(k == cost)
                return 1;
            return 0;
        }

        if(dp[i][max][cost] != null)
            return dp[i][max][cost];

        int result = 0;
        result =  (int) ((long) max * countArrays(n, m, k, i + 1, max, cost, dp) % mod);
        if(cost + 1 <= k) {
            for(int j = max + 1; j <= m; j++) {
                result += countArrays(n, m, k, i + 1, j, cost + 1, dp);
                result %= mod;
            }
        }
        dp[i][max][cost] = result % mod;
        return dp[i][max][cost];
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numOfArrays(2, 3, 1));
        System.out.println(s.numOfArrays(5, 2, 3));
        System.out.println(s.numOfArrays(9, 1, 1));

    }
}
