
public class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = 0; i < n; i++) {
            for(int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]]; 
            }
        }

        return dp[amount];
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.change(5, new int[] {1, 2, 5}));
    }
}


// 1 2 5

// fp(1) = 1
// fp(2) = fp(1) + 1
// fp(5) = fp(1) + fp(2) + 1