public class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int leftRangeIndex = -1, rightRangeIndex = -1, outsideRangeIndex = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < minK || nums[i] > maxK) {
                outsideRangeIndex = i;
                continue;
            }
            if(nums[i] == minK)
                leftRangeIndex = i;

            if(nums[i] == maxK)
                rightRangeIndex = i;

            count += Math.max(0, Math.min(leftRangeIndex, rightRangeIndex) - outsideRangeIndex);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countSubarrays(new int[] { 1, 3, 5, 2, 7, 5}, 1, 5));
        System.out.println(s.countSubarrays(new int[] { 1, 1, 1, 1}, 1, 1));
    }
}