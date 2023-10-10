import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 1, n = nums.length, maxCount = 0;
        int i = 0, first = 0, prev = nums[0];

        while(i < n) {
            while(i < n && nums[i] - nums[first] < n) {
                if(prev != nums[i])
                    count++;
                prev = nums[i];
                i++;
            }

            if(count > maxCount)
                maxCount = count;
            count = Math.max(1, count - 1);
            first++;
            while(first < n && nums[first - 1] == nums[first]) {
                first++;
            }
        }

        return n - maxCount;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minOperations(new int[] {44, 28, 33, 49, 4, 2, 35, 28, 25, 38, 47, 20, 14, 30, 27, 38, 42, 14, 34}));
        System.out.println(s.minOperations(new int[] {41, 33, 29, 33, 35, 26, 47, 24, 18, 28}));
        System.out.println(s.minOperations(new int[] {8, 5, 9, 9, 8, 4}));
        System.out.println(s.minOperations(new int[] {1, 2, 3, 5, 6}));
        System.out.println(s.minOperations(new int[] {1, 10, 100, 1000}));
    }
}
