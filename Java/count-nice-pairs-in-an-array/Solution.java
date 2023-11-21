import java.util.Arrays;

public class Solution {
    final static int mod = 1_000_000_007;

    public int countNicePairs(int[] nums) {
        long result = 0, count;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            nums[i] -= reverseNumber(nums[i]);
        }

        Arrays.sort(nums);
        n--;
        for(int i = 0; i < n; i++) {
            
            count = 1;
            while(i < n && nums[i] == nums[i + 1]) {
                count++;
                i++;
            }

            result = (result + (count * (count - 1)) / 2) % mod; 
        }
        return (int)result % mod;
    }

    public int reverseNumber(int num) {
        int number = 0;

        while(num > 0) {
            number = number * 10 + num % 10;
            num /= 10;
        }
        return number;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countNicePairs(new int[] {42, 11, 1, 97}));
        System.out.println(s.countNicePairs(new int[] {13, 10, 35, 24, 76}));
    }
}
