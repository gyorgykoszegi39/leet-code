
public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;

        for(int i = 1; i < nums.length; i++)
            if(nums[i - 1] != nums[i]) {
                nums[count] = nums[i];
                count++;
            }

        return count;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));

    }
}
