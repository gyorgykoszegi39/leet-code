public class Solution {

    public int[] findErrorNums(int[] nums) {
        int[] result = new int[] {-1, -1};
        for(int i : nums) {
            i = Math.abs(i) - 1;
            if(nums[i] > 0)
                nums[i] *= -1;
            else
                result[0] = i + 1;
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                result[1] = i + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        
        for(int  err : s.findErrorNums(new int[] { 1, 2, 2, 4})) {
            System.out.println(err);
        }
    }
}
