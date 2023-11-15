import java.util.Arrays;

public class Solution {
        
    public int countPalindromicSubsequence(String s) {
        int left, right, n = s.length(), countPalindrom = 0;
        char[] chars = s.toCharArray();
        int[] freq = new int[26];
        Arrays.fill(freq, -1);
        char ch;
        for(int c = 0; c <= 26; c++) {
            ch = (char) ('a' + c);

            left = 0;
            while(left < n && chars[left] != ch) {
                left++;
            }
            if(left != n) {
                right = n - 1;
                while(right >= 0 && chars[right] != ch) {
                    right--;
                }

                for(int i = left + 1; i < right; i++) {
                    if(freq[chars[i] - 'a'] != c) {
                        freq[chars[i] - 'a'] = c;
                        countPalindrom++;
                    }
                }
            }
        }
        return countPalindrom;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countPalindromicSubsequence("aabca"));
        System.out.println(s.countPalindromicSubsequence("adc"));
        System.out.println(s.countPalindromicSubsequence("bbcbaba"));
    }
}
