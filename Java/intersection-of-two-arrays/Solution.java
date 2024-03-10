import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> resultList = new ArrayList<>();
        int[] freq = new int[1001];

        for(int i : nums1)
            freq[i] = 1;

        for(int i : nums2) {
            if(freq[i] == 1) {
                resultList.add(i);
                freq[i] = 0;
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        for(int num : s.intersection(new int[] {1, 2, 2, 1}, new int[] {2, 2}))
            System.out.print(num + " ");
    }
}