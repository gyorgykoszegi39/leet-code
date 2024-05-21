import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        buildSubset(nums, 0, 0, result);

        return result;
    }

    public void buildSubset(int[] nums, int start, int prev, List<List<Integer>> result) {
        for(int i = start; i < nums.length; i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>(result.get(prev));
            subset.add(nums[i]);
            result.add(subset);

            buildSubset(nums, i + 1, result.size() - 1, result);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<Integer>> result = s.subsets(new int[] { 1, 2, 3 });

        for (List<Integer> list : result) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
