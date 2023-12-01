public class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder string1 = new StringBuilder(), string2 = new StringBuilder();

        for(String word: word1)
            string1.append(word);

        for(String word: word2)
            string2.append(word);

        return string1.toString().equals(string2.toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.arrayStringsAreEqual(new String[] {"ab", "c"}, new String[] {"a", "bc"}));
        System.out.println(s.arrayStringsAreEqual(new String[] {"a", "cb"}, new String[] {"ab", "c"}));
        System.out.println(s.arrayStringsAreEqual(new String[] {"abc", "d", "defg"}, new String[] {"abcddefg"}));
    }
}
