import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sums =  new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(sums.containsKey(nums[i])) {
                return new int[] {i, sums.get(nums[i])};
            }
            sums.put(target - nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(Solution.twoSum(new int[]{2, 2, 3, 1, 7,11,15}, 4)[0]);
        System.out.println(Solution.twoSum(new int[]{2, 2, 3, 1, 11,15}, 4)[1]);
    }
}
