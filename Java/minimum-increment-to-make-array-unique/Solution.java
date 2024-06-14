import java.util.Arrays;

public class Solution {
    public int minIncrementForUnique(int[] nums) {
        int count = 0;
        int max = 0;

        for (int num : nums)
            max = Math.max(max, num);

        int[] freq = new int[nums.length + max];

        for (int num : nums)
            freq[num]++;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] < 2)
                continue;

            freq[i + 1] += freq[i] - 1;
            count += freq[i] - 1;
        }

        return count;
    }

    public int minIncrementForUnique1(int[] nums) {
        int count = 0;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                count += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minIncrementForUnique(new int[] { 1, 2, 2 }));
        System.out.println(s.minIncrementForUnique(new int[] { 3, 2, 1, 2, 1, 7 }));
    }
}
