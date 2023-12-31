public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = 0;
        for(int i = 0; i < 26; i++)
            max = Math.max(max, s.lastIndexOf(i + 'a') - s.indexOf(i + 'a'));
        
        return max - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxLengthBetweenEqualCharacters("aa"));
        System.out.println(s.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(s.maxLengthBetweenEqualCharacters("cbzxy"));
    }
}
