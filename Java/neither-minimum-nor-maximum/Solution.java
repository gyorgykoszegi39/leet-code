
public class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length < 3)
            return -1;
    
        int max = Math.max(Math.max(nums[0], nums[1]), nums[2]);
        int min = Math.min(Math.min(nums[0], nums[1]), nums[2]);

        int i = 0;
        while(nums[i] == min || nums[i] == max)
            i++;

        return nums[i];

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findNonMinOrMax(new int[] {2, 1, 3}));
    }
}
