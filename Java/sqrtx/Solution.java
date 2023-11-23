public class Solution {
    public int mySqrt(int x) {
        long longX = (long) x;
        long mid, left = 0, right = longX;

        while(left < right) {
            mid = left + (right - left) / 2;
            if(mid * mid >= longX)
                right = mid;
            else
                left = mid + 1;
        }

        if(left * left != longX)
            left--;
        
        return (int) left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(4));
        System.out.println(s.mySqrt(8));
    }
}
