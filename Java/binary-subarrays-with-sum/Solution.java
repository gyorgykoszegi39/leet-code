public class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    
    private int atMost(int[] nums, int goal) {
        int left = 0, sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > goal && left <= i) {
                sum -= nums[left];
                left++;
            }
            count += i - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numSubarraysWithSum(new int[] {1, 0, 1, 0, 1}, 2));
        System.out.println(s.numSubarraysWithSum(new int[] {0, 0, 0, 0, 0}, 0));
    }
}
