
public class Solution {
    public int minimumOneBitOperations(int n) {
        int count = 0;

        while(n != 0) {
            count ^= n;
            n = n / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minimumOneBitOperations(3));
        System.out.println(s.minimumOneBitOperations(6));
    }
}
