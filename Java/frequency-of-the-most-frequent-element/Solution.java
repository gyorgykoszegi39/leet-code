import java.util.Arrays;

public class Solution {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxCount = 0, count = 0, j = 0;

        for(int i = 0; i < nums.length; i++) {
            count += nums[i];
            while(nums[i] * (i - j + 1) - count > k) {
                count -= nums[j];
                j++;
            }

            maxCount = Math.max(maxCount, i - j + 1);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxFrequency(new int[] {1, 2, 4}, 5));
        System.out.println(s.maxFrequency(new int[] {1, 4, 8, 13}, 5));

    }
}
