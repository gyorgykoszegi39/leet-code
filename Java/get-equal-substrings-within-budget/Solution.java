public class Solution {

    public int equalSubstring(String s, String t, int maxCost) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int start = 0, cost = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            cost += Math.abs(sChars[i] - tChars[i]);

            while (cost > maxCost) {
                cost -= Math.abs(sChars[start] - tChars[start]);
                start++;
            }

            count = Math.max(count, i - start + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.equalSubstring("abcd", "bcdf", 3));
        System.out.println(s.equalSubstring("krrgw", "zjxss", 19));

    }
}
