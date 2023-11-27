
public class Solution {

    final static int mod = 1_000_000_007;

    public int knightDialer(int n) {

        if(n == 1)
            return 10;

        long [] numbers = new long [] {2, 2, 2, 2, 3, 0, 3, 2, 2, 2};
        long [] prevNumbers = new long [10];

        int count = 0;

        for(int i = 2; i < n; i++) {
            for(int j = 0; j < 10; j++)
                prevNumbers[j] = numbers[j];

            numbers[0] = (prevNumbers[4] + prevNumbers[6]) % mod;
            numbers[1] = (prevNumbers[6] + prevNumbers[8]) % mod;
            numbers[2] = (prevNumbers[7] + prevNumbers[9]) % mod;
            numbers[3] = (prevNumbers[4] + prevNumbers[8]) % mod;
            numbers[4] = (prevNumbers[3] + prevNumbers[9] + prevNumbers[0]) % mod;
            numbers[6] = (prevNumbers[1] + prevNumbers[7] + prevNumbers[0]) % mod;
            numbers[7] = (prevNumbers[2] + prevNumbers[6]) % mod;
            numbers[8] = (prevNumbers[1] + prevNumbers[3]) % mod;
            numbers[9] = (prevNumbers[2] + prevNumbers[4]) % mod;
        }

        for(int i = 0; i < 10; i++)
            count = (count + (int)numbers[i]) % mod;
        return count % mod;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.knightDialer(1));
        System.out.println(s.knightDialer(2));
        System.out.println(s.knightDialer(3131));

    }
}
