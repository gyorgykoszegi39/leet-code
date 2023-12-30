public class Solution {
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];
        
        for(String word : words)
            for(char ch : word.toCharArray())
                count[ch - 'a']++;

        int countw = words.length;
        
        for(int i = 0; i < 26; i++)
            if(count[i] % countw != 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.makeEqual(new String[] {"abc", "aabc", "bc"}));
        System.out.println(s.makeEqual(new String[] {"ab", "a"}));
    }
}
