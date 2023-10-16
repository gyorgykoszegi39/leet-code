public class Solution {
    public boolean canJump(int[] nums) {
        int  n = nums.length, jump = n - 1;
        for(int i = n - 1; i >= 0; i--) {
            if(i + nums[i] >= jump) {
                jump = i;
            }
        }

        return jump == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
