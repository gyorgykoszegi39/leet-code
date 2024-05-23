import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;

public class Solution {

    public int beautifulSubsets(int[] nums, int k) {
        int totalCount = 1;
        TreeMap<Integer, TreeMap<Integer, Integer>> freqMap = new TreeMap<>();

        for (int num : nums) {
            TreeMap<Integer, Integer> freq = freqMap.getOrDefault(num % k, new TreeMap<>());
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            freqMap.put(num % k, freq);
        }

        for (Map.Entry<Integer, TreeMap<Integer, Integer>> entry : freqMap.entrySet()) {
            int prevNum = -k, prev2 = 0, prev1 = 1, curr = 1;

            for (Map.Entry<Integer, Integer> freqEntry : entry.getValue().entrySet()) {
                int num = freqEntry.getKey();
                int freq = freqEntry.getValue();
                int skip = prev1;
                int take = ((1 << freq) - 1) * (num - prevNum == k ? prev2 : prev1);

                curr = skip + take;
                prev2 = prev1;
                prev1 = curr;
                prevNum = num;
            }
            totalCount *= curr;
        }

        return totalCount - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.beautifulSubsets(new int[] { 1, 1, 2, 3 }, 1));
    }
}
