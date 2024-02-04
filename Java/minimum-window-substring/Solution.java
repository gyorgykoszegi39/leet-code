
public class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if(n < m)
            return "";

        int[] sFreq = new int[52], tFreq = new int[52], margin = new int[] {-1, n};
        for(char ch : t.toCharArray())
            tFreq[getIndexOfChar(ch)]++;
            
        char[] sChars = s.toCharArray();
        int left = 0, right = 0, i;
        while(left < n || right < n) {
            if(m > 0) {
                if(right >= n)
                    break;
                    
                i = getIndexOfChar(sChars[right]);
                if(sFreq[i] < tFreq[i]) {
                    m--;
                }
                sFreq[i]++;
                right++;
            } else {
                i = getIndexOfChar(sChars[left]);
                if(sFreq[i] == tFreq[i])
                    m++;
                sFreq[i]--;
                left++;
            }
            
            if(m == 0 && right - left < margin[1] - margin[0]) {
                margin[0] = left;
                margin[1] = right;
            }
        }

        if(margin[0] == -1)
            return "";

        return s.substring(margin[0], margin[1]);
    }

    private int getIndexOfChar(char ch) {
        return ch >= 'a' ? 26 + (ch - 'a') : ch - 'A';
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(s.minWindow("a", "a"));
        System.out.println(s.minWindow("a", "aa"));
        System.out.println(s.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}
