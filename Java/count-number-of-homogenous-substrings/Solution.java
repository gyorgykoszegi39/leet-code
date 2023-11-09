
public class Solution {
    final static int mod = 1_000_000_007;

    public int countHomogenous(String s) {
        int homogenous = 1, count = 1;
        for(int i = 1; i < s.length(); i++) {
            count = (s.charAt(i - 1) == s.charAt(i)) ? count + 1 : 1;
            homogenous = (homogenous + count) % mod;
        }

        return homogenous % mod;
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        System.out.println(s.countHomogenous("abbcccaa"));
        System.out.println(s.countHomogenous("xy"));
        System.out.println(s.countHomogenous("zzzzz"));
    }
}
