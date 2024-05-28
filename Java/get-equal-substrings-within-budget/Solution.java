public class Solution {

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int start = 0, cost = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            cost += Math.abs(s.charAt(i) - t.charAt(i));

            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(start) - t.charAt(start));
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
