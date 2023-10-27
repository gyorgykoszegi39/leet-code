public class Solution {
    public String longestPalindrome(String s) {
        int j, n = s.length();
        int longestPali = 0, longestPaliI = 0;

        for(int i = 0; i < n; i++) {
            j = 0;
            while(i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j)) {
                j++;
            }

            if(2 * j - 1 > longestPali) {
                longestPali = 2 * j - 1;
                longestPaliI = i - j + 1;
            }

            j = 0;
            while(i - j - 1>= 0 && i + j < n && s.charAt(i - j - 1) == s.charAt(i + j)) {
                j++;
            }

            if(2 * j > longestPali) {
                longestPali = 2 * j;
                longestPaliI = i - j;
            }
        }
        return s.substring(longestPaliI, longestPaliI + longestPali);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("babad"));
        System.out.println(s.longestPalindrome("cbbd"));
    }
}