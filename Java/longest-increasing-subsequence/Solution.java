public class Solution {
    public int lengthOfLIS(int[] nums) {
        int count = 0, start, end, mid;
        int[] dp = new int[nums.length];

        for(int num : nums) {
            start = 0;
            end = count;

            while(start != end) {
                mid = (start + end) / 2;
                if(dp[mid] < num)
                    start = mid + 1;
                else
                    end = mid;
            }

            dp[start] = num;
            if(start == count)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(new int[] {10, 9, 8, 2, 3, 4, 5, 9, 1, 2, 3, 4, 5}));
        System.out.println(s.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(s.lengthOfLIS(new int[] {0, 1, 0, 3, 2, 3}));
        System.out.println(s.lengthOfLIS(new int[] {7, 7, 7, 7, 7, 7, 7}));
    }
}
