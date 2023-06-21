
public class Solution {
    
    public long minCost(int[] nums, int[] cost) {
        int minRange = nums[0], maxRange = nums[0];
        int n = nums.length, mid;
        long minCost = 0, cost1, cost2;

        for(int i = 1; i < n; i++) {
            minRange = Math.min(minRange, nums[i]);
            maxRange = Math.max(maxRange, nums[i]);
        }

        if(minRange == maxRange)
            return minCost;
        
        while(minRange < maxRange) {
            mid = (minRange + maxRange) / 2;
            cost1 = calculateCost(nums, cost, mid);
            cost2 = calculateCost(nums, cost, mid + 1);

            if(cost1 < cost2) {
                maxRange = mid;
                minCost = cost1;
            } else {
                minRange = mid + 1;
                minCost = cost2;
            }
        }

        return minCost;
    }

    public long calculateCost(int[] nums, int[] cost, int number) {
        long sum = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            sum += (long) Math.abs(nums[i] - number) * cost[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minCost(new int[] {1, 3, 5, 2}, new int[] {2, 3, 1, 14}));
        System.out.println(s.minCost(new int[] {2  , 2, 2, 2}, new int[] {2, 3, 1, 14}));

    }
}
