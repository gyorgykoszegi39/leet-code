public class Solution {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length - 1, sum = 0;
        int[] sums = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            sums[i] = i * nums[i] - sum;
            sum += nums[i];
        }

        for(int i = 0; i <= n; i++) {
            sum -= nums[i];
            sums[i] += sum - (n - i) * nums[i];
        }

        return sums;
    }


    public int[] getSumAbsoluteDifferences1(int[] nums) {
        int n = nums.length - 1, sumLeftToRight = 0, sumRightToLeft = 0;
        int[] sums = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            sums[i] += i * nums[i] - sumLeftToRight;
            sums[n - i] += sumRightToLeft - i * nums[n - i];
            sumLeftToRight += nums[i];
            sumRightToLeft += nums[n - i];
        }

        return sums;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        for(int num : s.getSumAbsoluteDifferences(new int[] {2, 3, 5})) {
            System.out.print(num + " ");
        }
    }
}
