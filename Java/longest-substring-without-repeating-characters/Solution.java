import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Deque<Character> chars = new LinkedList<Character>();
        int max = 0;

        for(char ch : s.toCharArray()) {
            if(chars.contains(ch)) {
                max = Math.max(max, chars.size());

                while(chars.poll() != ch);
            }
            chars.add(ch);
        }
        max = Math.max(max, chars.size());

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("aaaaaaa"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring("dvdf"));
    }
}
