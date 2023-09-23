import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int longestStrChain(String[] words) {
        int result = 0;
        StringBuilder prevWord;
        Map<String, Integer> dp = new HashMap<>();

        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());

        for(int i = 0; i < words.length; i++) {
            int count = 0;
            for(int j = 0; j < words[i].length(); j++) {
                prevWord = new StringBuilder(words[i]);
                prevWord.deleteCharAt(j);
                count = Math.max(count, dp.getOrDefault(prevWord.toString(), 0) + 1);
            }
            dp.put(words[i], count);
            result = Math.max(result, count);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }
}
