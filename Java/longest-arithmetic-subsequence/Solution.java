import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestArithSeqLength(int[] nums) {
       int max = 0, n = nums.length;
        Map<Integer, Integer>[] arithSeq = new HashMap [n];

        for(int i = 0; i < n; i++) {
            arithSeq[i] = new HashMap<Integer, Integer>();
            for(int j = 0; j < i; j++) {
                Integer key = nums[j] - nums[i];
                int value = arithSeq[j].getOrDefault(key, 1) + 1;
                arithSeq[i].put(key, value);
                max = Math.max(value, max);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestArithSeqLength(new int[] {3, 6, 9, 12}));
        System.out.println(s.longestArithSeqLength(new int[] {20, 1, 15, 3, 10, 5, 8}));
        System.out.println(s.longestArithSeqLength(new int[] {44,46,22,68,45,66,43,9,37,30,50,67,32,47,44,11,15,4,11,6,20,64,54,54,61,63,23,43,3,12,51,61,16,57,14,12,55,17,18,25,19,28,45,56,29,39,52,8,1,21,17,21,23,70,51,61,21,52,25,28}));
    }
}