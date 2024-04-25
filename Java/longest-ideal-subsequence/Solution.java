public class Solution {
    
    public int longestIdealString(String s, int k) {
        int[] freq = new int[26];
        int maxLen = 0, cur = 0;
        
        
        for(char ch : s.toCharArray()) {
            cur = ch - 'a';
            freq[cur] = getMaxNeighbour(freq, cur, k) + 1;
        }

        for(int i = 0; i < 26; i++)
            maxLen = Math.max(maxLen, freq[i]);
        
        return maxLen;
    }

    public int getMaxNeighbour(int freq[], int cur, int k) {
        int start = Math.max(0, cur - k), end = Math.min(cur + k, 25), max = 0;
        for(int i = start; i <= end; i++)
            max = Math.max(max, freq[i]);

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.longestIdealString("acfgbd", 2));
        System.out.println(s.longestIdealString("abcd", 3));
        System.out.println(s.longestIdealString("pvjcci", 4));

    }
}
