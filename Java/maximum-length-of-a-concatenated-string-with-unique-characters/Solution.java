import java.util.Arrays;
import java.util.List;

public class Solution {
    private int max;
    public int maxLength(List<String> arr) {
        max = 0;
        buildWord(arr, 0, new StringBuilder());
        return max;
    }

    private void buildWord(List<String> arr, int i, StringBuilder word) {
        if(i >= arr.size()) {
            if(word.length() > max)
                max = word.length();
            return;
        }

        StringBuilder buildWord = new StringBuilder(word);
        buildWord.append(arr.get(i));
        boolean[] freq = new boolean[26];
        boolean validWord = true;

        for(int j = 0; j < buildWord.length(); j++) {
            int k = buildWord.charAt(j) - 'a';
            if(freq[k]) {
                validWord = false;
                break;
            }
            freq[k] = true;
        }

        buildWord(arr, i + 1, word);
        if(validWord)
            buildWord(arr, i + 1, buildWord);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxLength(Arrays.asList("un", "iq", "ue")));
        System.out.println(s.maxLength(Arrays.asList("cha", "r", "act", "ers")));
        System.out.println(s.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
    }
}
