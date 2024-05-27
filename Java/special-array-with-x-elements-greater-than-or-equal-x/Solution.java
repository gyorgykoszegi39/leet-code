import java.util.Arrays;

public class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, result = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] > result)
                result++;
            else
                return result == nums[i] ? -1 : result;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.specialArray(new int[] {3, 5}));
        System.out.println(s.specialArray(new int[] {0, 0}));
        System.out.println(s.specialArray(new int[] {0, 0, 4, 3, 4}));
        System.out.println(s.specialArray(new int[] {0, 4, 4, 3, 4}));
    }
}
