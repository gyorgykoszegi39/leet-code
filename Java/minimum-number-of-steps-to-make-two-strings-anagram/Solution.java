
public class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];

        for(char ch : s.toCharArray())
            freq[ch - 'a']++;

        for(char ch : t.toCharArray())
            freq[ch - 'a']--;

        int count = 0;
        for(int num : freq) {
            count += Math.abs(num);
        }

        return count / 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minSteps("bab", "aba"));
        System.out.println(s.minSteps("leetcode", "practice"));
        System.out.println(s.minSteps("anagram", "mangaar"));
    }
}
