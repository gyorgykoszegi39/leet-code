
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for(int i = 0; i < n; i++)
            sum += nums[i];

        return ((n * (n + 1) / 2) - sum);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.missingNumber(new int[] {0, 3, 2}));
    }
}
