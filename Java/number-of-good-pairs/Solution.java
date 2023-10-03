import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> savedNumberOfPairs = new HashMap<>();
        int count = 0, numberOfPairs;
        for(int num : nums) {
            numberOfPairs = savedNumberOfPairs.getOrDefault(num, 0);
            count += numberOfPairs;
            savedNumberOfPairs.put(num, numberOfPairs + 1);
        } 
    
        return count;
    }

    public int numIdenticalPairs1(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++)
            for(int j = i + 1; j < nums.length; j++)
                if(nums[i] == nums[j])
                    count++;
    
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numIdenticalPairs(new int[] {1, 2, 3, 1, 1, 3}));
        System.out.println(s.numIdenticalPairs1(new int[] {1, 2, 3, 1, 1, 3}));
    }
}
