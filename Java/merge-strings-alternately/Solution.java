
public class Solution {

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder mergedWord = new StringBuilder();

        int n = word1.length();
        int m =  word2.length();
        int i = 0;
        while(i < n && i < m) {
            mergedWord.append(word1.charAt(i));
            mergedWord.append(word2.charAt(i));
            i++;
        }

        while(i < n) {
            mergedWord.append(word1.charAt(i));
            i++;
        }

        while(i < m) {
            mergedWord.append(word2.charAt(i));
            i++;
        }

        return mergedWord.toString();
    }
    public static void main(String args[]) {
        System.out.println(Solution.mergeAlternately("abc", "qwerty"));
    }
}
