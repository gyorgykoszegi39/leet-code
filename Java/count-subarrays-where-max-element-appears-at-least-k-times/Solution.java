import java.util.HashMap;

public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE, countMax = 0, left = 0, right = 0, n = nums.length;
        long result = 0;
        for(int num : nums)
            max = Math.max(max, num);

        while(right < n) {
            if(nums[right] == max)
                countMax++;
            
            while(countMax == k) {
                if(nums[left] == max)
                    countMax--;

                left++;
                result += n - right;
            }
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSubarrays(new int[] {1, 3, 2, 3, 3}, 2));
        System.out.println(s.countSubarrays(new int[] {1, 4, 2, 1}, 2));
        System.out.println(s.countSubarrays(new int[] {5, 5, 5, 5, 5, 5}, 4));
    }
}
