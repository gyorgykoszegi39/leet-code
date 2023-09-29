public class Solution {
    public boolean isMonotonic(int[] nums) {
        int i = 1;
        while(i < nums.length && nums[i - 1] == nums[i]) {
            i++;
        }

        if(i == nums.length)
            return true;
        boolean isIncreasing = nums[i - 1] < nums[i];
        while(i < nums.length) {
            if(nums[i - 1] != nums[i] && nums[i - 1] < nums[i] != isIncreasing)
                return false;
            i++;
        }
        
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMonotonic(new int[] {1, 2, 2, 3}));
        System.out.println(s.isMonotonic(new int[] {1, 3, 2}));
        System.out.println(s.isMonotonic(new int[] {1, 1, 2}));

    }
}
