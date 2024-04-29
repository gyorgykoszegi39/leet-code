public class Solution {
    public int minOperations(int[] nums, int k) {
        int xorNums = nums[0];
        for(int i = 1; i < nums.length; i++) {
            xorNums ^= nums[i];
        }

        int count = 0;
        while(k != xorNums) {
            count += k % 2 == xorNums % 2 ? 0 : 1;
            k = k >> 1;
            xorNums = xorNums >> 1;
        }

        return count;
    }



    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minOperations(new int[] {2, 1, 3, 4}, 1));
        System.out.println(s.minOperations(new int[] {2, 0, 2, 0}, 0));
    }
}
