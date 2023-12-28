public class Solution {

    private int[][] dp;
    private char[] chars;
    private int n;

    public int getLengthOfOptimalCompression(String s, int k) {
        n = s.length();
        dp = new int[n + 1][k + 1];
        chars = s.toCharArray();

        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= k; j++)
                dp[i][j] = -1;

        return recSolve(0, k);
    }

    private int recSolve(int i, int k) {
        if(k < 0)
            return n;

        if(n <= i + k)
            return 0;
        
        int count = dp[i][k];
        if(count != -1)
            return count;

        count = recSolve(i + 1, k - 1);
        
        int distance = 0, same = 0, diff = 0;
        for(int j = i; j < n && diff <= k; j++) {
            if(chars[j] == chars[i]) {
                same++;
                distance += (same <= 2 || same == 10 || same == 100) ? 1 : 0;
            } else
                diff++;

            count = Math.min(count, distance + recSolve(j + 1, k - diff));
        }

        dp[i][k] = count;
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.getLengthOfOptimalCompression("aaabcccd", 2));
        System.out.println(s.getLengthOfOptimalCompression("aabbaa", 2));
        System.out.println(s.getLengthOfOptimalCompression("aaaaaaaaaaa", 0));
    }
}
