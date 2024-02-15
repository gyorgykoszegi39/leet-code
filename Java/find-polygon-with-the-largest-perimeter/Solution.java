import java.util.Arrays;

public class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0, result = -1;

        for(int num : nums) {
            sum += num;

            if(num * 2 < sum)
                result = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.largestPerimeter(new int[] {5, 5, 5}));
        System.out.println(s.largestPerimeter(new int[] {1, 12, 1, 2, 5, 50, 3}));
        System.out.println(s.largestPerimeter(new int[] {5, 5, 50}));
    }
}
