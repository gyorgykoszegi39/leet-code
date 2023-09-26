import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastOccurence = new int[26];
        boolean[] visitedChar = new boolean[26];
        StringBuilder result = new StringBuilder();

        int i = 0;
        for(char ch : s.toCharArray()) {
            lastOccurence[ch - 'a'] = i++;
        }

        i = 0;
        for(char ch : s.toCharArray()) {
            if(!visitedChar[ch - 'a']) {
                int lastIndex = result.length() - 1;
                while(lastIndex >= 0 && ch < result.charAt(lastIndex) && i < lastOccurence[result.charAt(lastIndex) - 'a']) {
                    visitedChar[result.charAt(lastIndex) - 'a'] = false;
                    result.deleteCharAt(lastIndex);
                    lastIndex--;
                }

                result.append(ch);
            }
            i++;
            visitedChar[ch - 'a'] = true;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicateLetters("bcabc"));
        System.out.println(s.removeDuplicateLetters("cbacdcbc"));
    }
}
