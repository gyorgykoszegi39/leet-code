public class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        char[] t1 = text1.toCharArray(), t2 = text2.toCharArray();
        
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++)
                if(t1[i - 1] == t2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

        return dp[n][m];
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++)
            for(int j = 0; j < text2.length(); j++)
                dp[i][j] = -1;

        return calculateLongestCommonSubsequence(dp, text1.toCharArray(), text2.toCharArray(), 0, 0);
    }

    private int calculateLongestCommonSubsequence(int[][] dp, char[] text1, char[] text2, int i, int j) {
        if(i == text1.length || j == text2.length)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(text1[i] == text2[j])
            return dp[i][j] = 1 + calculateLongestCommonSubsequence(dp, text1, text2, i + 1, j + 1);

        return dp[i][j] = Math.max(calculateLongestCommonSubsequence(dp, text1, text2, i + 1, j),
                                calculateLongestCommonSubsequence(dp, text1, text2, i, j + 1));
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.longestCommonSubsequence("abcde", "ace"));
        System.out.println(s.longestCommonSubsequence("abc", "abc"));
        System.out.println(s.longestCommonSubsequence("abc", "def"));
    }
}
