
public class Solution {

    public boolean isPowerOfTwo(int n) {
        return (n > 0 && (n & (n - 1)) == 0);
    }

    public boolean isPowerOfTwo1(int n) {
        if(n < 1)
            return false;
        
        while(n > 1) {
            if(n % 2 == 1)
                return false;
            n /= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isPowerOfTwo(1));
        System.out.println(s.isPowerOfTwo(16));
        System.out.println(s.isPowerOfTwo(3));
    }
}
