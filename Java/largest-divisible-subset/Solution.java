import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, max = 0;
        List<Integer> result = new ArrayList<>();
        int[] dp = new int[n], prevIndexes = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prevIndexes, -1);
        Arrays.sort(nums);


        for(int i = 1; i < n; i++)
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prevIndexes[i] = j;

                    if(dp[i] > dp[max])
                        max = i;
                }
            }

        while(max >= 0) {
            result.add(nums[max]);
            max = prevIndexes[max];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(Integer num : s.largestDivisibleSubset(new int[] {1, 2, 3})) {
            System.out.print(num + " ");
        }
        System.out.println();
        for(Integer num : s.largestDivisibleSubset(new int[] {1, 2, 4, 8})) {
            System.out.print(num + " ");
        }
        System.out.println();
        for(Integer num : s.largestDivisibleSubset(new int[] {5, 90, 15, 3, 4, 6, 30})) {
            System.out.print(num + " ");
        }
    }
}
