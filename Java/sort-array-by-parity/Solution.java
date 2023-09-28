
public class Solution {
    
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;

        while(left < right) {
            if(nums[left] % 2 != 0) {
                int swap = nums[left];
                nums[left] = nums[right];
                nums[right] = swap;
                right--;
            } else {
                left++;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        for(int num : s.sortArrayByParity(new int[] {3, 1, 2, 4})) {
            System.out.println(num);
        }
    }
}
