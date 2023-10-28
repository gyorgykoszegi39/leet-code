public class Solution {

    final static int mod = 1_000_000_007;

    public int countVowelPermutation(int n) {
        long[] prev = new long[] {1, 1, 1, 1, 1};
        long[] curr = new long[] {1, 1, 1, 1, 1};

        if(n == 1)
            return 5;
        
        for(int i = 0; i < n - 1; i++) {
            curr[0] = ( prev[1] + prev[2] + prev[4] ) % mod;
            curr[1] = ( prev[0] + prev[2] ) % mod;
            curr[2] = ( prev[1] + prev[3] ) % mod;
            curr[3] = ( prev[2] ) % mod;
            curr[4] = ( prev[2] + prev[3] ) % mod;
            for(int j = 0; j < 5; j++) {
                prev[j] = curr[j];
            }
        }

        long sum = 0;
        for(int i = 0; i < 5; i++) {
            sum += curr[i];
        }

        return (int) (sum % mod);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countVowelPermutation(1));
        System.out.println(s.countVowelPermutation(2));
        System.out.println(s.countVowelPermutation(3));
        System.out.println(s.countVowelPermutation(5));
    }
}
