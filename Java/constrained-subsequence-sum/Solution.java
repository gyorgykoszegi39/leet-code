import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> maxSums = new ArrayDeque<>();
        int maxSum = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(!maxSums.isEmpty()) {
                nums[i] += maxSums.peek();
            }
            maxSum = Math.max(maxSum, nums[i]);

            while(!maxSums.isEmpty() && nums[i] > maxSums.peekLast()) {
                maxSums.pollLast();
            }

            if(nums[i] > 0)
                maxSums.offer(nums[i]);

            if(i >= k && !maxSums.isEmpty() && maxSums.peek() == nums[i - k])
                maxSums.poll();
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.constrainedSubsetSum(new int[] {10, 2, -10, 5, 20}, 2));
    }
}
