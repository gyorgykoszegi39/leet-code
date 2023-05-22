import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Solution {

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        List<Integer> []bucketSort = new List[nums.length + 1];

        for(int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Entry<Integer, Integer> element : freqMap.entrySet()) {
            if(bucketSort[element.getValue()] == null)
                bucketSort[element.getValue()] = new ArrayList<Integer>();
            
            bucketSort[element.getValue()].add(element.getKey());
        }

        int[] result = new int[k];
        int ind = 0;
        for(int i = nums.length; i >= 0 && k > 0; i--) {
            if(bucketSort[i] != null) {
                k -= bucketSort[i].size();

                for(Integer ans: bucketSort[i]) {
                    result[ind++] = ans;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] test = {1, 1, 1, 2, 2, 3};

        for(int i : Solution.topKFrequent(test, 2))
            System.out.println(i);

    }
}
