import java.util.Arrays;

public class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int max = 0, n = nums.length - 1;
        for(int i = 0; i < nums.length / 2; i++) {
            if(nums[i] + nums[n - i] > max)
                max = nums[i] + nums[n - i];
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minPairSum(new int[] {3, 5, 2, 3}));
        System.out.println(s.minPairSum(new int[] {3, 5, 4, 2, 4, 6}));

    }
}
