import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        int k;
        for(int i = 0; i < l.length; i++) {
            int[] subArr = new int[r[i] - l[i] + 1];
            k = 0;
            for(int j = l[i]; j <= r[i]; j++)
                subArr[k++] = nums[j];
            result.add(isArithmetic(subArr));
        }
        return result;
    }

    private Boolean isArithmetic(int []nums) {
        Arrays.sort(nums);
        int diff = nums[1] - nums[0];

        for(int i = 2; i < nums.length; i++) {
            if(nums[i] - nums[i - 1] != diff)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(Boolean n : s.checkArithmeticSubarrays(new int[] { 4, 6, 5, 9, 3, 7}, new int[] {0, 0, 2}, new int[] {2, 3, 5})) {
            System.out.print(n + " ");
        }
    }
}
