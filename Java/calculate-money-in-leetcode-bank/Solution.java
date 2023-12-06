public class Solution {
    public int totalMoney(int n) {
        int r =  n % 7;
        int d = n / 7;

        return d * (28 + r) + 7 * (d * (d - 1) / 2) + (r * (r + 1) / 2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalMoney(7));
        System.out.println(s.totalMoney(14));
        System.out.println(s.totalMoney(4));
        System.out.println(s.totalMoney(10));
        System.out.println(s.totalMoney(20));
    }
}
