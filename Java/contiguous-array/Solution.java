import java.util.Arrays;
public class Solution {

    public int findMaxLength(int[] nums) {
        int countDifference = 0, result = 0, n = nums.length;
        int[] differenceArray = new int[2* n + 1];
        Arrays.fill(differenceArray, -2);
        differenceArray[n] = -1;

        for(int i = 0; i < n; i++) {
            countDifference += (nums[i] == 0 ? -1: 1);

            if(differenceArray[countDifference + n] >= -1)
                result = Math.max(result, i - differenceArray[countDifference + n]);
            else
                differenceArray[countDifference + n] = i;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findMaxLength(new int[] {0, 1}));
        System.out.println(s.findMaxLength(new int[] {0, 1, 0}));
    }
}
