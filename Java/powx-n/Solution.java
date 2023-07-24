
public class Solution {
    public double myPow(double x, int n) {
        long m = n;
        if(n == 0)
            return 1;

        if(n < 0) {
            x = 1 / x;
            m = -m;
        }

        double result = 1;
        while(m > 0) {
            if( m % 2 == 1)
                result *= x;

            x *= x;
            m /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(2, 10));
        System.out.println(s.myPow(2.1, 3));
        System.out.println(s.myPow(2, -2));

    }

}
