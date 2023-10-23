public class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }

    public boolean isPowerOfFour1(int n) {
        long pow = 1;

        while(pow <= n) {
            if(pow == n)
                return true;
            pow *= 4;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfFour(16));
    }
}
