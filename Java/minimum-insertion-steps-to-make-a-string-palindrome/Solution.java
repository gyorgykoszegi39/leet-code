
public class Solution {
    public static int minInsertions(String s) {
        int n = s.length();
        int m[][] = new int[n][n];

        for(int i = n - 1; i >= 0 ; i--) {
            m[i][i] = 1;
            for(int j = i + 1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    m[i][j] = m[i + 1][j - 1] + 2;
                } else {
                    m[i][j] = Math.max(m[i + 1][j], m[i][j-1]);
                }
            }
        }

        return n - m[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(Solution.minInsertions("bbbab"));
        System.out.println(Solution.minInsertions("cbbd"));

    }
}
