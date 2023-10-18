public class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int minNum = nums[0], maxNum = nums[0];

        for(int num : nums) {
            if(num < minNum)
                minNum = num;
            if(num > maxNum)
                maxNum = num;
        }
        minNum += k;
        maxNum -= k;

        return maxNum < minNum ? 0 : maxNum - minNum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.smallestRangeI(new int[] {0, 10},  2));
    }
}
