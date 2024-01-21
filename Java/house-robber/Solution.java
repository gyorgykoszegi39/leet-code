public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1 || (nums.length == 2 && nums[0] > nums[1]))
            return nums[0];
        
        nums[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++)
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);

        return nums[nums.length - 1];
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.rob(new int[] {1, 2, 3, 1}));
        System.out.println(s.rob(new int[] {2, 7, 9, 3, 1}));
        System.out.println(s.rob(new int[] {7, 1, 1, 7}));
    }
}
