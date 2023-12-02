public class Solution {
    
    public int countCharacters(String[] words, String chars) {
        int count = 0, i;
        int freqChars[] = new int[26];
        int freqCharsCurrent[] = new int[26];
        boolean isGood;

        for(char ch : chars.toCharArray())
            freqChars[ch - 'a']++;

        for(String word : words) {
            for(i = 0; i < 26; i++)
                freqCharsCurrent[i] = 0;
            isGood = true;
            for(char ch : word.toCharArray()) {
                i = ch - 'a';
                freqCharsCurrent[i]++;

                if(freqCharsCurrent[i] > freqChars[i]) {
                    isGood = false;
                    break;
                }
            }

            if(isGood)
                count += word.length();
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countCharacters(new String[] {"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(s.countCharacters(new String[] {"hello","world","leetcode"}, "welldonehoneyr"));
    }
}
