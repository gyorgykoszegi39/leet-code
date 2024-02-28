public class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return matchChars(s.toCharArray(), p.toCharArray(), 0, 0, dp);
    }

    private boolean matchChars(char[] s, char[] p, int i, int j, Boolean[][] dp) {
        if(j == p.length)
            return i == s.length;    

        if(dp[i][j] != null)
            return dp[i][j];

        if(j + 1 < p.length && p[j+1] == '*') {
            if(matchChars(s, p, i, j + 2, dp)) {
                return dp[i][j] = true;
            }
            
            return dp[i][j] = (i < s.length && (s[i] == p[j] || p[j] == '.')) && matchChars(s, p, i + 1, j, dp);   
        } else 
            return dp[i][j] = (i < s.length && (s[i] == p[j] || p[j] == '.')) && matchChars(s, p, i + 1, j + 1, dp);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(s.isMatch("aa", "aa")); 
        //System.out.println(s.isMatch("aa", "a"));
        //System.out.println(s.isMatch("aa", "a."));
        System.out.println(s.isMatch("aa", "a*"));
        System.out.println(s.isMatch("ab", ".*"));
        System.out.println(s.isMatch("ab", ".*."));
        System.out.println(s.isMatch("ab", ".*..*"));
        System.out.println(s.isMatch("aab", "c*a*b"));
    }
}