import java.util.ArrayList;

public class Solution {
    //Sum of Two Squares Theorem && Legrende's Three Square Theorem
    public int numSquares(int n) {
        
        int square, isSquare = (int) Math.sqrt(n);
        
        if(isSquare * isSquare == n)
            return 1;
        while(n % 4 == 0)
            n /= 4;

        if(n % 8 == 7)
            return 4;

        for(int i = 1; i * i <= n; i++) {
            square = i * i;
            isSquare = (int) Math.sqrt(n - square);

            if(isSquare * isSquare == n - square)
                return 2;
        }

        return 3;
    }

    public int numSquares1(int n) {
        int min, reminder;
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                reminder = i - j * j;
                if(dp[reminder] <  min)
                    min = dp[reminder];
            }
            dp[i] = min + 1;
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numSquares(12));
        System.out.println(s.numSquares(13));
    }
}
