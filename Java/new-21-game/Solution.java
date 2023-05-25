
public class Solution {
    public static double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[n + 1];
        dp[0] = 1;
        double pSum = 1, reuslt = 0;
        if(k == 0 || n >= k + maxPts) return 1;

        for(int i = 1 ; i <= n; i++) {
            dp[i] = pSum / maxPts;
            if(i < k) {
                pSum += dp[i];
            } else {
                reuslt += dp[i];
            }

            if(i - maxPts >= 0) {
                pSum -= dp[i - maxPts];
            }
        }
        return reuslt;
    }

    public static void main(String[] args) {
        System.out.println(Solution.new21Game(10, 1, 10));
        System.out.println(Solution.new21Game(6, 1, 10));
        System.out.println(Solution.new21Game(21, 17, 10));
    }
}

/*
    n * (n + 1)
  
  
 */
