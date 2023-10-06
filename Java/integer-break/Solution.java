public class Solution {

    public int integerBreak(int n) {
        if(n <= 3)
            return n - 1;

        int p = n / 3;
        int rest = n % 3;
        if(rest == 1) {
            p--;
            rest = 4;
        }
        rest = rest == 0 ? 1 : rest;
        
        return (int) Math.pow(3, p) * rest;
    }

    

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.integerBreak(2));
        System.out.println(s.integerBreak(3));
        System.out.println(s.integerBreak(4));
        System.out.println(s.integerBreak(5));
        System.out.println(s.integerBreak(6));
        System.out.println(s.integerBreak(10));
        System.out.println(s.integerBreak(8));
    }
}
