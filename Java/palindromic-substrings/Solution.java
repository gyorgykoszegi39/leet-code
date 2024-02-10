public class Solution {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            count += countPalindrom(chars, i, true);
            count += countPalindrom(chars, i, false);
        }
        return count;
    }

    private int countPalindrom(char[] chars, int i, boolean isMid) {
        int left = i, right = i + 1, n = chars.length, count = 0;

        if(isMid) {
            left--;
            count++;
        }
        
        while(left >= 0 && right < n && chars[left] == chars[right]) {
            right++;
            left--;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countSubstrings("abc"));
        System.out.println(s.countSubstrings("aaa"));
    }
}
