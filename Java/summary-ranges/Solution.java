import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<String>();
        int i = 0, n = nums.length, left;

        while(i < n) {
            left = nums[i];

            while(i < n - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if(left == nums[i]) {
                results.add(String.format("%d", left));
            } else {
                results.add(String.format("%d->%d", left, nums[i]));
            }
            //i++;
        }

        return results;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(String result : s.summaryRanges(new int[] {0, 3, 4, 5, 7, 8})) {
            System.out.println(result);
        }
    }
}
