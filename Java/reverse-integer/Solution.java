public class Solution {
    public int reverse(int x) {
        long reversed = 0;
        while(x != 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        if(reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE)
            return 0;
        
        return (int)reversed;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.reverse(123));
        System.out.println(s.reverse(-123));
        System.out.println(s.reverse(120));
        System.out.println(s.reverse(1534236469));
    }
}
