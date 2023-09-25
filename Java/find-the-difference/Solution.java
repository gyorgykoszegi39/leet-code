
public class Solution {
    public char findTheDifference(String s, String t) {
        int countChars = 0;

        for(char ch : s.toCharArray()) {
            countChars -= ch;
        }

        for(char ch : t.toCharArray()) {
            countChars += ch;

        }

        return (char) countChars;
    }

    public char findTheDifference1(String s, String t) {
        int[] countChars = new int[26];

        for(char ch : s.toCharArray()) {
            countChars[ch - 'a']++;
        }

        for(char ch : t.toCharArray()) {
            if(countChars[ch - 'a'] == 0)
                return ch;
            
                countChars[ch - 'a']--;
        }

        return 'a';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findTheDifference("abcd", "abcde"));
    }
}