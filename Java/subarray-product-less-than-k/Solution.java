public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1, count = 0, j = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > k) {
                j = i + 1;
                product = 1;
                continue;
            }

            product *= nums[i];
            while(product >= k) {
                product /= nums[j];
                j++;
            }

            count += i - j + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
        System.out.println(s.numSubarrayProductLessThanK(new int[] {1, 2, 3}, 0));

    }
}
