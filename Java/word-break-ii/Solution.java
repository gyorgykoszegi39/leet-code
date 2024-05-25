import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class Solution {
    Map<String, List<String>> dp = new HashMap<>();

    public List<String> wordBreak1(String s, List<String> wordDict) {
        if (dp.containsKey(s))
            return dp.get(s);

        List<String> result = new LinkedList<>();
        if (wordDict.contains(s))
            result.add(s);

        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i), right = s.substring(i);
            if (wordDict.contains(left)) {
                for (String word : wordBreak(right, wordDict))
                    result.add(left + " " + word);
            }
        }
        dp.put(s, result);

        return result;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> results = new ArrayList<>();
        buildSentence(s, new HashSet<>(wordDict), 0, new StringBuilder(), results);
        return results;
    }

    void buildSentence(String s, Set<String> wordSet, int start, StringBuilder sentence, List<String> results) {
        if (start == s.length())
            results.add(sentence.toString().trim());


        for (int i = start + 1; i <= s.length(); i++) {
            String word = s.substring(start, i);
            if (wordSet.contains(word)) {
                int len = sentence.length();
                sentence.append(word).append(" ");
                buildSentence(s, wordSet, i, sentence, results);
                sentence.setLength(len);
            }
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> dictionary = new ArrayList<>();

        dictionary.add("cat");
        dictionary.add("cats");
        dictionary.add("and");
        dictionary.add("sand");
        dictionary.add("dog");

        List<String> sentences = s.wordBreak("catsanddog", dictionary);

        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
