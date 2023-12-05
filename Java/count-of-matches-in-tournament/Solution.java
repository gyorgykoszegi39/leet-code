public class Solution {
    public int numberOfMatches(int n) {
        return n - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numberOfMatches(7));
        System.out.println(s.numberOfMatches(14));

    }
}
