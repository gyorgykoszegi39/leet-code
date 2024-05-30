import java.util.HashMap;
import java.util.Map;
public class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length, count = 0, prefix = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> totalMap = new HashMap<>();

        countMap.put(0, 1);
        for (int i = 0; i < n; ++i) {
            prefix ^= arr[i];

            count += countMap.getOrDefault(prefix, 0) * i - totalMap.getOrDefault(prefix, 0);

            totalMap.put(prefix, totalMap.getOrDefault(prefix, 0) + i + 1);
            countMap.put(prefix, countMap.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countTriplets(new int[] {2, 3, 1, 6, 7}));
    }
}
