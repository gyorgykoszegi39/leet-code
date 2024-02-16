import java.util.Map;
import java.util.HashMap;

public class Solution {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if(arr.length <= k || k == 0)
            return 0;
        
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int[] freqCount = new int[10000];

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet())  {
            freqCount[entry.getValue()]++;
        }

        int result = freqMap.size(), i = 1;
        while(k > 0) {
            if(k > freqCount[i] * i) {
                k -= freqCount[i] * i;
                result -= freqCount[i];
            } else {
                result -= k / i;
                k = 0;
            }
            i++;
        }

        return result;
    }


    public int findLeastNumOfUniqueInts1(int[] arr, int k) {
        if(arr.length <= k)
            return arr.length;
        
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        int[] sorted = freqMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .mapToInt(Map.Entry::getValue)
                .toArray();

        int i = 0;
        while(i < sorted.length && k >= 0) {
            k -= sorted[i];
            i++;
        }

        return sorted.length - i + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findLeastNumOfUniqueInts(new int[] { 5, 5, 4}, 1));
        System.out.println(s.findLeastNumOfUniqueInts(new int[] { 5, 5, 4}, 2));
        System.out.println(s.findLeastNumOfUniqueInts(new int[] { 4, 3, 1, 1, 3, 3, 2}, 3));

    }    
}
