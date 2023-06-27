
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++)
            result ^= nums[i];

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.singleNumber(new int[]{2, 2, 1}));
    }
}
