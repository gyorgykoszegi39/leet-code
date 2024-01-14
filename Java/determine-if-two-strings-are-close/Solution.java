import java.util.Arrays;

public class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;

        int[] freq1 = new int[26], freq2 = new int[26];
        for(char ch : word1.toCharArray())
            freq1[ch - 'a']++;
        for(char ch : word2.toCharArray())
            freq2[ch - 'a']++;
        
        for(int i = 0; i < 26; i++)
            if(freq1[i] > 0 ^ freq2[i] > 0)
                return false;
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for(int i = 0; i < 26; i++)
            if(freq1[i] != freq2[i])
                return false;
        
        return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.closeStrings("abc", "bca"));
        System.out.println(s.closeStrings("a", "aa"));
        System.out.println(s.closeStrings("cabbba", "abbccc"));
    }
}
