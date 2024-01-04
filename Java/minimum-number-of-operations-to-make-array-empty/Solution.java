import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);

        int result = 0, count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] == nums[i])
                count++;
            else {
                if(count == 1)
                    return -1;
                result += count / 3 + (count % 3 == 0 ? 0 : 1);
                count = 1;
            }
        }

        if(count == 1)
            return -1;
        
        return result + count / 3 + (count % 3 == 0 ? 0 : 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minOperations(new int[] {2, 3, 3, 2, 2, 4, 2, 3, 4}));
        System.out.println(s.minOperations(new int[] {2, 1, 2, 2, 3, 3}));
    }
}
