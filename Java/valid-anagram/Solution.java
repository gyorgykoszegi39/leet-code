
public class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) 
            return false;

        int freq[] = new int[26];

        for(char ch : s.toCharArray())
            freq[ch - 'a']++;

        for(char ch : t.toCharArray())
            freq[ch - 'a']--;

        for(int f : freq)
            if(f != 0)
                return false;
        
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isAnagram("anagram", "nagaram"));
        System.out.println(s.isAnagram("rat", "car"));
    }
}
