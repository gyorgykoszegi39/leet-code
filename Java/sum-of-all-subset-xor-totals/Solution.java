public class Solution {

    public int subsetXORSum(int[] nums) {
        return calculateXorSum(nums, 0, 0);
    }

    private int calculateXorSum(int[] nums, int i, int num) {
        if(i == nums.length)
            return num;

        return calculateXorSum(nums, i + 1, num ^ nums[i]) + calculateXorSum(nums, i + 1, num);
    }

    public int subsetXORSum1(int[] nums) {
        int n = nums.length, xorSum, sum = 0;
        for(int i = 0; i < 1 << n; i++) {
            xorSum = 0;
            for(int j = 0; j < n; j++)
                if((i & (1 << j)) != 0)
                    xorSum ^= nums[j];
            sum += xorSum;
        }

        return sum;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsetXORSum(new int[] {1, 3}));
        System.out.println(s.subsetXORSum(new int[] {5, 1, 6}));
    }
}
