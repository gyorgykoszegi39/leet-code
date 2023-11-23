
public class Solution {
    public boolean isHappy(int n) {
        int tortoise = n; // Floyd Cycle
        int hare = squareSum(n);

        while(hare != 1 && tortoise != hare) {
            tortoise = squareSum(tortoise);
            hare = squareSum(squareSum(hare));
        }
        
        return hare == 1;
    }

    private int squareSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }

        return sum;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isHappy(19));
        System.out.println(s.isHappy(2));

    }
}
