import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, sum = 0;
        int[][] dp = new int[n][n];
        HashMap<Long, ArrayList<Integer>> hs = new HashMap<>();
        long key;
        for(int i = 0; i < n; i++) {
            hs.putIfAbsent((long)nums[i], new ArrayList<Integer>());
            hs.get((long)nums[i]).add(i);
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                key = 2L * nums[i] - nums[j];

                if(hs.containsKey(key)) {
                    for(int num : hs.get(key)) {
                        if(num >= i)
                            break;
                        dp[i][j] += dp[num][i] + 1;
                    }
                }

                sum += dp[i][j];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numberOfArithmeticSlices(new int[] {2, 4, 6, 8, 10}));
        System.out.println(s.numberOfArithmeticSlices(new int[] {7, 7, 7, 7, 7}));
    }
}
