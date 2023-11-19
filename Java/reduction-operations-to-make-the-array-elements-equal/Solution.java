import java.util.Arrays;

public class Solution {

    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0, level = 0, n = nums.length, i;

        i = 1;
        while(i < n) {
            while(nums[i - 1] == nums[i]) {
                count += level;
                i++;

                if(i == n) {
                    return count;
                }
            }
            i++;
            level++;
            count += level;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.reductionOperations(new int[] {5, 1, 3}));
        System.out.println(s.reductionOperations(new int[] {1, 1, 1}));
        System.out.println(s.reductionOperations(new int[] {1, 1, 2, 2, 3}));
    }
}
