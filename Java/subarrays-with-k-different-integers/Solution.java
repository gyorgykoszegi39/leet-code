public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }

    public int solve(int[] nums, int k) {
        int result = 0, count = 0, j = 0;
        int freq[] = new int[20001];

        for(int i = 0; i < nums.length; i++) {
            if(freq[nums[i]] == 0) {
                count++;
            }

            freq[nums[i]]++;

            while(count > k) {
                freq[nums[j]]--;
                if(freq[nums[j]] == 0)
                    count--;
                j++;
            }

            result += i - j + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.subarraysWithKDistinct(new int[] {1, 2, 1, 2, 3}, 2));
        System.out.println(s.subarraysWithKDistinct(new int[] {1, 2, 1, 3, 4}, 3));
    }
}
