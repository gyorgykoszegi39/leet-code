public class Solution {
    final static int mod = 1_000_000_007;

    public int checkRecord(int n) {
        long[] dpPorL = new long[n + 1];
        long[] dpP = new long[n + 1];
        dpPorL[0] = dpP[0] = 1; 
        dpPorL[1] = 2; 
        dpP[1] = 1;
    
        for (int i = 2; i <= n; i++) {
            dpP[i] = dpPorL[i - 1];
            dpPorL[i] = (dpP[i] + dpP[i - 1] + dpP[i - 2]) % mod;
        }
        
        long result = dpPorL[n], sum;
        for (int i = 0; i < n; i++) {
            sum = (dpPorL[i] * dpPorL[n - i - 1]) % mod;
            result = (result + sum) % mod;
        }
        
        return (int) result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.checkRecord(1));
        System.out.println(s.checkRecord(2));
        System.out.println(s.checkRecord(3));
        System.out.println(s.checkRecord(4));
        System.out.println(s.checkRecord(5));
        System.out.println(s.checkRecord(6));
        System.out.println(s.checkRecord(7));
        System.out.println(s.checkRecord(8));
        System.out.println(s.checkRecord(9));
        System.out.println(s.checkRecord(10));

    }
}
