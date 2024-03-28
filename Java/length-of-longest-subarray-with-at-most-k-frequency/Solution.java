import java.util.HashMap;

public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0, j = 0;
        int minRange = Integer.MAX_VALUE, maxRange = Integer.MIN_VALUE;
        for(int num : nums) {
            minRange = Math.min(minRange, num);
            maxRange = Math.max(maxRange, num);
        }

        int[] freq = new int[maxRange - minRange + 1];

        for(int i = 0; i < nums.length; i++) {
            freq[nums[i] - minRange]++;

            while(freq[nums[i] - minRange] > k)
                freq[nums[j++] - minRange]--;

            max = Math.max(max, i - j + 1);
        }

        return max;
    }

    public int maxSubarrayLength1(int[] nums, int k) {
        int max = 0, j = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            while(freq.get(nums[i]) > k) {
                freq.put(nums[j], freq.get(nums[j]) - 1);
                j++;
            }

            max = Math.max(max, i - j + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxSubarrayLength(new int[] {1, 2, 3, 1, 1, 1, 2, 3, 1, 2}, 2));
        System.out.println(s.maxSubarrayLength(new int[] {1, 2, 3, 1, 2, 3, 1, 2}, 2));
        System.out.println(s.maxSubarrayLength(new int[] {5, 5, 5, 5, 5, 5}, 4));
    }
}
