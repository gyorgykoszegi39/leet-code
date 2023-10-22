public class Solution {
    public int maximumScore(int[] nums, int k) {
        int left = k, right = k;
        int minNum = nums[k], maxScore = nums[k];

        while(left > 0 || right < nums.length - 1) {
            if(left == 0 || right < nums.length - 1 && nums[right + 1] > nums[left - 1]) {
                right++;
                minNum = Math.min(minNum, nums[right]);
            }
            else {
                left--;
                minNum = Math.min(minNum, nums[left]);
            }

            maxScore = Math.max(maxScore, minNum * (right - left + 1));
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumScore(new int[] {1, 4, 3, 7, 4, 5}, 3));
    }
}
